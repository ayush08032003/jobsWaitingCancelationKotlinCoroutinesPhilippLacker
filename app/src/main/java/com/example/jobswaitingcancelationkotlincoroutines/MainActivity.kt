package com.example.jobswaitingcancelationkotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val TAG = "debugAyush"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val job = GlobalScope.launch(Dispatchers.Default){
//            repeat(5){
//                Log.d(TAG, "Coroutine is Still Working...!")
//                delay(1000L)
//            }
            Log.d(TAG,"Starting Complex Calculations..!")
            withTimeout(3000L) {
                for (i in 30..40) {
                    if(isActive){
                        val ans = fib(i)
                        Log.d(TAG, "Printing the Fibonacci Number of i=$i  : ${ans}")
                    }
                }
            }
//            for(i in 30..40){
//                if(isActive){
//                    val ans = fib(i)
//                    Log.d(TAG,"Printing the Fibonacci Number of i=$i  : ${ans}")
//                }
//            }
            Log.d(TAG,"Ending Complex Calculations..!")
        }
//        runBlocking {
//            delay(2000L)
//            job.cancel()
//            Log.d(TAG,"THe Job has Been Canceled.. ${Thread.currentThread().name}")
//        }
        Log.d(TAG, "Main Thread is Continuing.. ${Thread.currentThread().name} ")

    }
    fun fib(n : Int) : Long{
        return if(n == 0) 0
            else if(n == 1) 1
            else fib(n-1)+fib(n-2)
    }
}

/*
NOTES/STEPS :
This tutorial is about Coroutines job and how we can we wait for them or cancel them.
GlobalScope.launch returns a job which can be stored in a variable
by using join() we can suspend every other thread until this coroutine gets finished.
cancel() will cancel the coroutine as soon as it is executed.!
Now sometimes, during long calculations and anything that takes long time, we need to explicity check whether the corouiine is still active or not..
To doo that, we need to use if(isActive)
withTimeout(timemilis) works same and we don't have to cancel the job manually, it will automatically cancel the job, but we need to
check whether the given coroutine is still active or not using if(isActive). 

 */