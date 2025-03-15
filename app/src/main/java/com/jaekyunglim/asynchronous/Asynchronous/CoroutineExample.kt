package com.jaekyunglim.asynchronous.Asynchronous

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineExample {
    // companion object: 클래스 내부에서 정적 멤버를 정의하는 블록
    companion object {
        private val TAG = "로그"

        // companion object 메서드
        fun fetchDataWithCoroutine() {
            Log.d(TAG, "Coroutine 시작 (메인 스레드): ${Thread.currentThread().name}")

            val startTime = System.currentTimeMillis()

            CoroutineScope(Dispatchers.IO).launch {
                Log.d(TAG, "네트워크 요청 실행 (IO 스레드): ${Thread.currentThread().name}")
                val result = withContext(Dispatchers.IO) {
                    fetchFromNetwork() // suspend 함수 호출 (백그라운드 스레드에서 실행)
                }

                val endTime = System.currentTimeMillis()
                Log.d(TAG, "Coroutine 작업 완료! 소요 시간: ${endTime - startTime}ms")

                withContext(Dispatchers.Main) {
                    Log.d(TAG, "UI 업데이트 (메인 스레드): ${Thread.currentThread().name}")
                    updateUI(result) // UI 업데이트 (메인 스레드에서 실행)
                }
            }
        }

        // suspend 함수: 코루틴 내부에서만 호출할 수 있는 함수
        suspend fun fetchFromNetwork(): String {
            delay(1000) // 네트워크 요청 시뮬레이션
            return "네트워크 데이터"
        }

        // companion object 메서드
        fun updateUI(result: String) {
            Log.d(TAG, "UI 업데이트 완료: $result")
        }
    }
}
