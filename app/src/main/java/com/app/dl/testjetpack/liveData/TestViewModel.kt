package com.app.dl.testjetpack.liveData

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    var mCurrent: MutableLiveData<String>? = null
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field
        }

    //返回mCurrent值的长度
    var liveDataMap: LiveData<Int> = Transformations
        .map<String, Int>(mCurrent!!) {
            input: String -> input.length
        }

    var liveDataSwitch: LiveData<String> =
            Transformations.switchMap<String, String>(mCurrent!!) {
                input: String -> MutableLiveData<String>().also { it.value = input.toLowerCase() }
            }
}