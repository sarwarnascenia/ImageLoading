package com.sarwar.myapplication.mvload.core.remote

import  com.sarwar.myapplication.mvload.core.RequestData
import io.reactivex.Observable

interface RemoteRepo {
    fun getStream(requestData: RequestData): Observable<ByteArray>
}