package com.sarwar.myapplication.mvload


import android.graphics.Bitmap
import  com.sarwar.myapplication.mvload.core.GetDataUseCase
import  com.sarwar.myapplication.mvload.core.Method
import  com.sarwar.myapplication.mvload.core.RequestData
import  com.sarwar.myapplication.mvload.core.StreamRepoImpl
import  com.sarwar.myapplication.mvload.core.executor.UIExecutor
import  com.sarwar.myapplication.mvload.core.inmemory.InMemoryRepoImpl
import  com.sarwar.myapplication.mvload.core.mapper.BitmapMapper
import  com.sarwar.myapplication.mvload.core.mapper.JSONArrayMapper
import  com.sarwar.myapplication.mvload.core.mapper.JSONObjectMapper
import  com.sarwar.myapplication.mvload.core.mapper.StreamMapper
import  com.sarwar.myapplication.mvload.core.remote.RemoteRepoImpl
import org.json.JSONArray
import org.json.JSONObject


class MVLoadClient {

    fun requestAsBitmap(
        url: String, method: Method = Method.GET, urlParams: Map<String, String>? = null,
        headers: Map<String, String>? = null, callback: (Bitmap?, Throwable?) -> Unit
    ): kotlin.Any {
        return GetDataUseCase(
            UIExecutor(), StreamRepoImpl(
                RemoteRepoImpl(),
                InMemoryRepoImpl
            ), BitmapMapper()
        ).execute(RequestData(url, method, urlParams, headers), callback)
    }


    fun requestAsJsonObject(
        url: String, method: Method = Method.GET, urlParams: Map<String, String>? = null,
        headers: Map<String, String>? = null, callback: (JSONObject?, Throwable?) -> Unit
    ): kotlin.Any {
        return GetDataUseCase(
            UIExecutor(), StreamRepoImpl(
                RemoteRepoImpl(),
                InMemoryRepoImpl
            ), JSONObjectMapper()
        ).execute(RequestData(url, method, urlParams, headers), callback)
    }

    fun requestAsJsonArray(
        url: String, method: Method = Method.GET, urlParams: Map<String, String>? = null,
        headers: Map<String, String>? = null, callback: (JSONArray?, Throwable?) -> Unit
    ): kotlin.Any {
        return GetDataUseCase(
            UIExecutor(), StreamRepoImpl(
                RemoteRepoImpl(),
                InMemoryRepoImpl
            ), JSONArrayMapper()
        ).execute(RequestData(url, method, urlParams, headers), callback)
    }

    fun <T> requestAsGeneric(
        url: String, method: Method = Method.GET, urlParams: Map<String, String>? = null,
        headers: Map<String, String>? = null, mapper: StreamMapper<ByteArray, T>, callback: (T?, Throwable?) -> Unit
    ) {

        return GetDataUseCase(
            UIExecutor(), StreamRepoImpl(
                RemoteRepoImpl(),
                InMemoryRepoImpl
            ), mapper
        ).execute(RequestData(url, method, urlParams, headers), callback)

    }

}
