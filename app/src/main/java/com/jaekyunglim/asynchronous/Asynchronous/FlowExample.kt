package com.jaekyunglim.asynchronous

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class FlowExample {
    companion object {
        private const val TAG = "로그"

        fun fetchDataWithFlow(): Flow<String> = flow {
            val startTime = System.currentTimeMillis()

            Log.d(TAG, "Flow 시작 (IO 스레드): ${Thread.currentThread().name}")
            emit("데이터 로딩 중...")
            delay(1000) // 네트워크 요청 시뮬레이션
            emit("네트워크 데이터")

            val endTime = System.currentTimeMillis()
            Log.d(TAG, "Flow 작업 완료! 소요 시간: ${endTime - startTime}ms")
        }.flowOn(Dispatchers.IO) // IO 스레드에서 실행

        fun observeFlow() {
            CoroutineScope(Dispatchers.Main).launch {
                fetchDataWithFlow().collect { result ->
                    Log.d(TAG, "UI 업데이트 (메인 스레드): ${Thread.currentThread().name} - $result")
                }
            }
        }
    }
}
