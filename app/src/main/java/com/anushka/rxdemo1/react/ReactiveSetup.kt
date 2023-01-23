package com.anushka.rxdemo1.react

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class ReactiveSetup {

        private val greeting = "Hello From Reactive class: ${ReactiveSetup::class.simpleName}"              // interim-input-stream
        var _firstObservable : Observable<String>
        var observer : Observer<String>
        init {
            _firstObservable = Observable.just(greeting)
            observer = setObserver()
            _firstObservable.subscribe(observer)
        }

        companion object {
            private fun setObserver() = object: Observer<String> {

                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "onSubscribe called")
                }

                override fun onNext(t: String) {
                    Log.d(TAG, "onNext called")
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "onError called")
                }

                override fun onComplete() {
                    Log.d(TAG, "onComplete called")
                }
            }

            val TAG: String = Companion::class.java.toString()

        }
    }

