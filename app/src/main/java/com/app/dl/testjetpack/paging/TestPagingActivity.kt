package com.app.dl.testjetpack.paging

import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.app.dl.testjetpack.R

class TestPagingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_paging)

        //分页配置
        val myPagingConfig =
            PagedList.Config.Builder()
                .setPageSize(50) //页面大小，每次加载时加载的数量
                .setPrefetchDistance(150) //预取距离，给定UI中最后一个可见Item
                .setEnablePlaceholders(true) //ui占位符
                .build()

    }

}