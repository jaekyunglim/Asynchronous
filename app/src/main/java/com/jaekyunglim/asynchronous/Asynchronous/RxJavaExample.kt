package com.jaekyunglim.asynchronous.Asynchronous

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RxJavaExample {
    companion object {

        private const val TAG = "로그"

        fun fetchDataWithRxJava() {
            Log.d(TAG, "RxJava 시작 (메인 스레드): ${Thread.currentThread().name}")

            val startTime = System.currentTimeMillis()

            Single.fromCallable {
                Log.d(TAG, "네트워크 요청 실행 (IO 스레드): ${Thread.currentThread().name}")
                Thread.sleep(1000) // 네트워크 요청 시뮬레이션
                "네트워크 데이터"
            }
                .subscribeOn(Schedulers.io()) // IO 스레드에서 실행
                .observeOn(AndroidSchedulers.mainThread()) // 메인 스레드에서 실행
                .subscribe { result ->
                    val endTime = System.currentTimeMillis()
                    Log.d(TAG, "RxJava 작업 완료! 소요 시간: ${endTime - startTime}ms")
                    Log.d(TAG, "UI 업데이트 (메인 스레드): ${Thread.currentThread().name} - $result")
                }
        }

    }
}