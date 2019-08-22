package com.sarwar.myapplication.mvload.core

import  com.sarwar.myapplication.mvload.core.inmemory.InMemoryRepo
import  com.sarwar.myapplication.mvload.core.remote.RemoteRepo
import io.reactivex.Observable


interface StreamRepo {

    fun getStream(params: RequestData): Observable<ByteArray>
}

open class StreamRepoImpl(private val remote: RemoteRepo, private val inMemory: InMemoryRepo) : StreamRepo {

    override fun getStream(params: RequestData): Observable<ByteArray> {

        return inMemory.getCached(params.url).switchIfEmpty(remote.getStream(params).doOnNext {
            inMemory.put(params.url, it)
        })
    }

}