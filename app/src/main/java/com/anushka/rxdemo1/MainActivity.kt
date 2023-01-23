package com.anushka.rxdemo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anushka.rxdemo1.databinding.ActivityMainBinding
import com.anushka.rxdemo1.react.ReactiveSetup
import io.reactivex.rxjava3.core.Observable

class MainActivity : AppCompatActivity() {

    private lateinit var viewBasedBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBasedBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(viewBasedBinding.root)

        setupObservers().doOnNext {
            viewBasedBinding.tvGreeting.text = it
        }.subscribe()

    }

    private fun setupObservers() : Observable<String> {
        val reactiveSetup = ReactiveSetup()
        return reactiveSetup._firstObservable
    }

    companion object {
        private const val TAG = "myApp"

    }
}