package com.sarwar.myapplication.pinterest.model

import com.google.gson.Gson
import com.sarwar.myapplication.mvload.MVLoadClient
import com.sarwar.myapplication.mvload.core.mapper.StreamMapper
import com.sarwar.myapplication.pinterest.model.dto.PinterestItem
import javax.inject.Inject


class PinterestModelImpl @Inject constructor(private val clint: MVLoadClient) : PinterestModel {
    override fun getPinterestList(callback: (List<PinterestItem>?, Throwable?) -> Unit) {

        clint.requestAsGeneric("http://pastebin.com/raw/wgkJgazE",
                mapper = object : StreamMapper<ByteArray, List<PinterestItem>> {
                    override fun map(input: ByteArray): List<PinterestItem> {
                        return Gson().fromJson(String(input),
                                Array<PinterestItem>::class.java).toList()
                    }
                }, callback = callback)

    }


}