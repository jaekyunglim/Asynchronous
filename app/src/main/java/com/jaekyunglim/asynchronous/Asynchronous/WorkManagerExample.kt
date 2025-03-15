package com.jaekyunglim.asynchronous

import android.content.Context
import android.util.Log
import androidx.work.*

class WorkManagerExample {
    companion object {

        private const val TAG = "로그"

        class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
            override fun doWork(): Result {
                val startTime = System.currentTimeMillis()

                Log.d(TAG, "백그라운드 작업 시작 (WorkManager 스레드): ${Thread.currentThread().name}")
                Thread.sleep(2000) // 네트워크 요청 시뮬레이션

                val endTime = System.currentTimeMillis()
                Log.d(TAG, "WorkManager 작업 완료! 소요 시간: ${endTime - startTime}ms")

                return Result.success()
            }
        }

        fun startWorkManager(context: Context) {
            val workRequest = OneTimeWorkRequestBuilder<MyWorker>().build()
            WorkManager.getInstance(context.applicationContext).enqueue(workRequest)
        }
    }
}
