package com.rtukpe.fixtures.ui.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatDialogFragment
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RelativeLayout
import butterknife.Unbinder
import com.rtukpe.fixtures.di.component.ActivityComponent


abstract class BaseDialog : AppCompatDialogFragment(), DialogMvpView {

    lateinit var baseActivity: BaseActivity
        private set
    lateinit var mUnBinder: Unbinder

    override val isNetworkConnected: Boolean
        get() = baseActivity.isNetworkConnected

    val activityComponent: ActivityComponent?
        get() = baseActivity.activityComponent

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val mActivity = context
            this.baseActivity = mActivity
            mActivity.onFragmentAttached()
        }
    }

    override fun showLoading() {
        baseActivity.showLoading()
    }

    override fun hideLoading() {
        baseActivity.hideLoading()
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

    override fun hideKeyboard() {

        baseActivity.hideKeyboard()
    }

    fun setUnBinder(unBinder: Unbinder) {
        mUnBinder = unBinder
    }

    protected abstract fun setUp(view: View)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // the content
        val root = RelativeLayout(activity)
        root.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

        // creating the fullscreen dialog
        val dialog = Dialog(baseActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(root)
        if (dialog.window != null) {
            dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        dialog.setCanceledOnTouchOutside(false)

        return dialog
    }

    override fun show(fragmentManager: FragmentManager, tag: String) {
        val transaction = fragmentManager.beginTransaction()
        val prevFragment = fragmentManager.findFragmentByTag(tag)
        if (prevFragment != null) {
            transaction.remove(prevFragment)
        }
        transaction.addToBackStack(null)
        show(transaction, tag)
    }

    override fun dismissDialog(tag: String) {
        dismiss()
        baseActivity.onFragmentDetached(tag)
    }

    override fun onDestroy() {
        mUnBinder.unbind()
        super.onDestroy()
    }
}