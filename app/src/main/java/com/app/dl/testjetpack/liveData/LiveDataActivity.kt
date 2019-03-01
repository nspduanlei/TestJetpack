package com.app.dl.testjetpack.liveData

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.app.dl.testjetpack.R
import com.app.dl.testjetpack.viewmodel.Model

class LiveDataActivity: AppCompatActivity() {

    lateinit var tvTest: TextView
    lateinit var tvMap: TextView
    lateinit var tvSwitch: TextView
    lateinit var mModel: TestViewModel
    lateinit var btnA: Button
    lateinit var btnB: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        tvTest = findViewById(R.id.tv_test)

        //创建观察者对象，定义onChange() 方法中的操作
        val nameObservable = Observer<String> {
            tvTest.text = it
        }

        //如果在ViewModel中使用LiveData， 先创建ViewModel的对象
        mModel = ViewModelProviders.of(this).get(TestViewModel::class.java)

        //设置mCurrent的订阅观察
        /**
         * LifecycleOwer的observe()方法将
         * 观察者对象附加到LiveData对象，
         * 这将观察对象向LiveData对象订阅，以便
         * 通知其更改
         */

        mModel.mCurrent!!.observe(this, nameObservable)


        tvMap = findViewById(R.id.tv_map)
        tvSwitch = findViewById(R.id.tv_switch)

        val lengthObservable = Observer<Int> {
            tvMap.text = it.toString()
        }

        val lowObservable = Observer<String> {
            tvSwitch.text = it
        }

        mModel.liveDataMap.observe(this, lengthObservable)
        mModel.liveDataSwitch.observe(this, lowObservable)

        /**
         * observeForever(Observer)方法注册一个没有
         * 关联的生命周期所有者对象的观察者，
         * 在这种情况下，观察者被认为总是活动的，
         * 因此总是通知修改，可以删除这些观察员调用
         * removeObserver(Observer)
         */
        //mModel.liveDataSwitch.observeForever(lowObservable)

        btnA = findViewById(R.id.btn_a)
        btnB = findViewById(R.id.btn_b)

        btnA.setOnClickListener {
            mModel.mCurrent!!.value = "AAAAAAAAAA"
        }

        btnB.setOnClickListener {
            mModel.mCurrent!!.value = "BBBBB"
        }
    }
}