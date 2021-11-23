package com.infini8ai.naseemexecutive.data.update

import androidx.fragment.app.FragmentActivity
import com.infini8ai.naseemexecutive.data.prefs.IPref
import javax.inject.Inject

class UpdateManagerImpl @Inject constructor(private val activity: FragmentActivity, val iPref: IPref) :
    UpdateManager {

}