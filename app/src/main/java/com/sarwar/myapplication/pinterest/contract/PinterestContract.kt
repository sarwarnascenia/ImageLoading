package com.sarwar.myapplication.pinterest.contract

import  com.sarwar.myapplication.base.presenter.BasePresenter
import  com.sarwar.myapplication.base.view.MvpView
import  com.sarwar.myapplication.pinterest.model.dto.PinterestItem

interface PinterestContract {

    interface PinterestView : MvpView {
        fun showLoading()
        fun hideLoading()
        fun showSearchResultSuccess(projects: List<PinterestItem>, firstVisibleCellIndex: Int = 0, loadMore: Boolean)
        fun showSearchResultFailure(msg: String)
    }

    abstract class PinterestPresenter : BasePresenter<PinterestView>() {
        abstract fun getPinterestList(pageNumber: Int, loadMore: Boolean)
    }
}