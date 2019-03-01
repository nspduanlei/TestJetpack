package com.app.dl.testjetpack.lifecycle

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.app.dl.testjetpack.R

class LifeCyclerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycler)

        var myObserver =
            MyObserver(lifecycle, object : Callback {
                override fun update(string: String) {
                    Toast.makeText(this@LifeCyclerActivity, string, Toast.LENGTH_SHORT).show()
                }
            })

        lifecycle.addObserver(myObserver)

        findViewById<Button>(R.id.btn_test1).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}