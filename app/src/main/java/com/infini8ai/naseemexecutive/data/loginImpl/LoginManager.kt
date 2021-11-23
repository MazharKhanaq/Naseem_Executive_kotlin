package com.infini8ai.naseemexecutive.data.loginImpl

import androidx.lifecycle.MutableLiveData

interface LoginManager {

    fun initFirebase()
    fun loginWithEmailAndPassword(email:String, password:String)
    fun subscribe() : MutableLiveData<Int>
}