package com.infini8ai.naseemexecutive.screens.prinicipal_dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infini8ai.naseemexecutive.data.ON_CLICK_FEE_BTN
import com.infini8ai.naseemexecutive.data.ON_INVENTORY_CLICKED
import com.infini8ai.naseemexecutive.data.prefs.IPref
import com.infini8ai.naseemexecutive.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PrincipalDashbaordViewModel
@Inject
constructor(
private val repository: RetroRepository,
private val pref: IPref
) : ViewModel()
{



















    val clickEvents: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }

    fun onFeeClicked() {
        clickEvents.value = ON_CLICK_FEE_BTN
    }


    fun onInventoryClicked() {
        clickEvents.value = ON_INVENTORY_CLICKED
    }

}