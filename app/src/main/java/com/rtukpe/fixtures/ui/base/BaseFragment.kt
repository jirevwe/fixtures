package com.rtukpe.fixtures.ui.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.View
import butterknife.Unbinder
import com.rtukpe.fixtures.di.component.ActivityComponent
import com.rtukpe.fixtures.ui.base.BaseActivity.OnBackClicked
import com.rtukpe.fixtures.utils.others.CommonUtils
import com.rtukpe.fixtures.utils.others.RecyclerViewClickListener

/**
 * Created by rtukpe on 13/03/2018.
 */

abstract class BaseFragment : Fragment(), MvpView, RecyclerViewClickListener, OnBackClicked {

    lateinit var baseActivity: BaseActivity
        private set
    lateinit var mUnBinder: Unbinder
    lateinit var mProgressDialog: ProgressDialog

    override val isNetworkConnected: Boolean
        get() = baseActivity.isNetworkConnected

    val activityComponent: ActivityComponent?
        get() = baseActivity.activityComponent

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity
            this.baseActivity = activity
            activity.onFragmentAttached()
        }
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = CommonUtils.showLoadingDialog(baseActivity)
    }

    override fun hideLoading() {
        if (mProgressDialog.isShowing) {
            mProgressDialog.cancel()
        }
    }

    override fun onError(message: String) {
        baseActivity.onError(message)
    }

    override fun onError(@StringRes resId: Int) {
        baseActivity.onError(resId)
    }

    override fun showMessage(message: String) {
        baseActivity.showMessage(message)
    }

    override fun showMessage(@StringRes resId: Int) {
        baseActivity.showMessage(resId)
    }

    override fun show(message: String, useToast: Boolean) {
        baseActivity.show(message, useToast)
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun hideKeyboard() {
        baseActivity.hideKeyboard()
    }

    fun setUnBinder(unBinder: Unbinder) {
        mUnBinder = unBinder
    }

    protected abstract fun setUp(view: View)

    override fun onDestroy() {
        mUnBinder.unbind()
        super.onDestroy()
    }

    override fun onBackClicked(): Boolean {
        return false
    }
}