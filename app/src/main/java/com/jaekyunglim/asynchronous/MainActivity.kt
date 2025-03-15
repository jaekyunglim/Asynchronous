package com.jaekyunglim.asynchronous

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jaekyunglim.asynchronous.Asynchronous.CoroutineExample
import com.jaekyunglim.asynchronous.Asynchronous.RxJavaExample

class MainActivity : AppCompatActivity() {
    private val TAG = "로그"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 버튼 클릭 이벤트 추가
        findViewById<Button>(R.id.Coroutine).setOnClickListener {
            Log.d(TAG, "Coroutine 버튼 클릭됨")
            CoroutineExample.fetchDataWithCoroutine()
        }

        findViewById<Button>(R.id.Flow).setOnClickListener {
            Log.d(TAG, "Flow 버튼 클릭됨")
            FlowExample.observeFlow()
        }

        findViewById<Button>(R.id.WorkManager).setOnClickListener {
            Log.d(TAG, "WorkManager 버튼 클릭됨")
            WorkManagerExample.startWorkManager(this)
        }

        findViewById<Button>(R.id.RxJava).setOnClickListener {
            Log.d(TAG, "RxJava 버튼 클릭됨")
            RxJavaExample.fetchDataWithRxJava()
        }
    }
}