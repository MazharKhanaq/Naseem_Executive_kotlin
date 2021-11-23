package com.infini8ai.naseemexecutive.screens.login

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infini8ai.naseemexecutive.data.ON_CLICK_LOGIN_IN
import com.infini8ai.naseemexecutive.model.responses.UserRegisterRes
import com.infini8ai.naseemexecutive.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: RetroRepository) : ViewModel() {

    var email: ObservableField<String> = ObservableField<String>()
    var password: ObservableField<String> = ObservableField<String>()
    var mLoading = ObservableBoolean(false)


    fun onSigInUserClick() {
        mLoading.set(true)
        signUpEvent.value = ON_CLICK_LOGIN_IN
    }


    fun updateLoading(){
        mLoading.set(false)

    }

    fun getOrganization(): LiveData<Response<UserRegisterRes>> {
        mLoading.set(true)
        return repository.getOrganizationForLogin(
            email.get(),
            password.get()


        )
    }







    /* live data for sending events back to view */
    val signUpEvent: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }

}