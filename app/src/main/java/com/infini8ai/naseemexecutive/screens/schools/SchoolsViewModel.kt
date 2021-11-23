package com.infini8ai.naseemexecutive.screens.schools

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infini8ai.naseemexecutive.data.prefs.IPref
import com.infini8ai.naseemexecutive.model.responses.UserRegisterRes
import com.infini8ai.naseemexecutive.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SchoolsViewModel @Inject constructor(
    private val repository: RetroRepository) :
    ViewModel()
{

    var mLoading = ObservableBoolean(false)

    var mHasOrganizations = ObservableBoolean(false)


    fun updateLoading() {
        mLoading.set(false)
    }
    fun updateOrganizations(booleanVale: Boolean) {
        mHasOrganizations.set(booleanVale)
    }

    fun getSchools(organizationId: String): LiveData<Response<UserRegisterRes>> {
        mLoading.set(true)
        return repository.getSchools(organizationId)
    }


    val onClickEvents: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }



}