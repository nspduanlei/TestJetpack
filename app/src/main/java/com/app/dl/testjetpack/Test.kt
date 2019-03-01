package com.app.dl.testjetpack

import android.app.Activity
import android.widget.TextView

class Test : Activity() {
    lateinit var tvTest: TextView

    fun test() {
        tvTest = TextView(this)

    }
}
