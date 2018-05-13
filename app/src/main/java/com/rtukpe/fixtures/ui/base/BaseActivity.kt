package com.rtukpe.fixtures.ui.base

import android.annotation.TargetApi
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import butterknife.Unbinder
import com.rtukpe.fixtures.R
import com.rtukpe.fixtures.di.component.ActivityComponent
import com.rtukpe.fixtures.di.component.DaggerActivityComponent
import com.rtukpe.fixtures.di.module.ActivityModule
import com.rtukpe.fixtures.root.MvpApp
import com.rtukpe.fixtures.utils.others.CommonUtils
import com.rtukpe.fixtures.utils.others.NetworkUtils
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener

/**
 * Created by rtukpe on 13/03/2018.
 */

abstract class BaseActivity : AppCompatActivity(), MvpView, RecyclerViewClickListener {

    var onBackClickedListener: OnBackClicked? = null
    var mProgressDialog: ProgressDialog? = null
    lateinit var activityComponent: ActivityComponent
        private set
    lateinit var mUnBinder: Unbinder

    override val isNetworkConnected: Boolean
        get() = NetworkUtils.isNetworkConnected(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((application as MvpApp).component).build()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setUp()
    }

    override fun onBackPressed() {
        if (onBackClickedListener != null && onBackClickedListener!!.onBackClicked()) {
            return
        }
        super.onBackPressed()
    }


    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = CommonUtils.showLoadingDialog(this)
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    protected fun setTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar!!.title = ""
            supportActionBar!!.title = title
        }
    }

    override fun show(message: String, useToast: Boolean) {
        if (useToast)
            showMessage(message)
        else
            showSnackBar(message)
    }

    private fun showSnackBar(message: String) {
        val snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
        val sbView = snackbar.view

        val textView = sbView.findViewById<TextView>(android.support.design.R.id.snackbar_text)
        textView.setTextColor(ContextCompat.getColor(this, R.color.white))
        snackbar.show()
    }

    override fun onError(message: String) {
        showSnackBar(message)
    }

    override fun onError(@StringRes resId: Int) {
        onError(getString(resId))
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(@StringRes resId: Int) {
        showMessage(getString(resId))
    }

    fun onFragmentAttached() {

    }

    fun onFragmentDetached(tag: String) {

    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    abstract fun showHideToolBar(hide: Boolean)

    fun setUnBinder(unBinder: Unbinder) {
        mUnBinder = unBinder
    }

    override fun onDestroy() {
        mUnBinder.unbind()
        super.onDestroy()
    }

    protected abstract fun setUp()

    interface OnBackClicked {
        fun onBackClicked(): Boolean
    }
}
