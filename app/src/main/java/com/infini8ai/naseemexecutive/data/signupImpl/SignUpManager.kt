package com.infini8ai.naseemexecutive.data.signupImpl

import androidx.lifecycle.MutableLiveData

interface SignUpManager {


    fun initFirebase()
    fun SignUpWithEmailAndPassword(email:String, password:String)
    fun subscribe() : MutableLiveData<Int>

}
