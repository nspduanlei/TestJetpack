package com.app.dl.testjetpack.viewmodel

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.app.dl.testjetpack.R

class TestActivity : AppCompatActivity() {

    lateinit var tvModel: TextView
    lateinit var btnChange: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vm_test)

        Log.i("testdl", "onCreate---------------")

        var model = ViewModelProviders.of(this)[Model::class.java]

        tvModel = findViewById(R.id.tv_model)
        tvModel.text = model.textName

        btnChange = findViewById(R.id.btn_change)

        btnChange.setOnClickListener {
            model.textName = "Change = 22222"
            tvModel.text = model.textName
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        Log.i("testdl", "onConfigurationChanged---------------")
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.i("testdl", "onSaveInstanceState---------------")
    }
}