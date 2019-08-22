package com.sarwar.myapplication.pinterest.model

import com.sarwar.myapplication.pinterest.model.dto.PinterestItem


interface PinterestModel {

    fun getPinterestList(callback: (List<PinterestItem>?, Throwable?) -> Unit)
}