package com.sarwar.myapplication.base.presenter

import  com.sarwar.myapplication.base.view.MvpPresenter
import  com.sarwar.myapplication.base.view.MvpView
import java.lang.ref.WeakReference

abstract class BasePresenter<V : MvpView> : MvpPresenter<V> {
    private var viewRef: WeakReference<V>? = null


    protected val isViewAttached: Boolean
        get() = viewRef != null && viewRef?.get() != null

    protected val view: V?
        get() = viewRef?.get()

    override fun onAttach(view: V) {
        viewRef = WeakReference(view)
    }


    override fun onResume() {

    }

    override fun onDetach() {
        if (viewRef != null) {
            viewRef!!.clear()
            viewRef = null
        }

    }

}
