package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.annotation.IntegerRes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myObserver = MyObserver()
        lifecycle.addObserver(myObserver)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            putString("KEY", counter.text.toString())
        }

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        counter.text = savedInstanceState.getString("KEY")
    }

    fun addCounter (view: View) {
        val countString = counter.text.toString()

        var count: Int = Integer.parseInt(countString)
        count++

        counter.text = count.toString()
    }

    fun subtractCounter (view: View) {
        val countString = counter.text.toString()

        var count: Int = Integer.parseInt(countString)
        count--

        counter.text = count.toString()
    }
}
