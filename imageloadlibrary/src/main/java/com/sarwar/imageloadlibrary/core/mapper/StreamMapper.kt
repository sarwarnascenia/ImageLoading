package com.sarwar.myapplication.mvload.core.mapper

interface StreamMapper<in Input, out Result> {

    fun map(input: Input): Result
}