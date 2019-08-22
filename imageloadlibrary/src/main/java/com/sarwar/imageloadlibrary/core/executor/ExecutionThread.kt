package com.sarwar.myapplication.mvload.core.executor

import io.reactivex.Scheduler

interface ExecutionThread {
    val subscribeScheduler: Scheduler
    val observerScheduler: Scheduler
}