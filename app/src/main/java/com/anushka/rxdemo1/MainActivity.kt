package com.anushka.rxdemo1

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainActivity : AppCompatActivity() {

    private val greeting = "Hello From RxJava"              // interim-input-stream
    lateinit var _firstObservable : Observable<String>
    lateinit var observer : Observer<String>

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.tvGreeting)

        _firstObservable = Observable.just(greeting)
        observer = setObserver()

        _firstObservable.subscribe(observer)


    }

    private fun setObserver() = object: Observer<String> {

        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe called")
        }

        override fun onNext(t: String) {
            Log.d(TAG, "onNext called")
            textView.text = t
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError called")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete called")
        }
    }

    companion object {
        private const val TAG = "myApp"

    }
}