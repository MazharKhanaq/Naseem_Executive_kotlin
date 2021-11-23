package com.infini8ai.naseemexecutive.screens.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import androidx.viewbinding.ViewBinding
import com.infini8ai.naseemexecutive.BaseActivity
import com.infini8ai.naseemexecutive.R
import com.infini8ai.naseemexecutive.data.DELAY_HOME
import com.infini8ai.naseemexecutive.data.DELAY_LOGIN
import com.infini8ai.naseemexecutive.data.KEY_USER_LOGIN
import com.infini8ai.naseemexecutive.data.impl.IRes
import com.infini8ai.naseemexecutive.data.prefs.IPref
import com.infini8ai.naseemexecutive.databinding.ActivitySplashBinding
import com.infini8ai.naseemexecutive.navigator.Navigator
import com.infini8ai.naseemexecutive.navigator.Screen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    /* view objects */
//    lateinit var developerView: TextView

    /* dependency objects */
    @Inject
    lateinit var navigor: Navigator

    @Inject
    lateinit var pref: IPref

    @Inject
    lateinit var res: IRes




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }





    override fun onResume() {
        Log.d("SplashActivity", "onResume: ")
        super.onResume()

        loadNextScreen(
            if (pref.bool(KEY_USER_LOGIN)) Screen.HOME else Screen.LOGIN,
            if (pref.bool(KEY_USER_LOGIN)) DELAY_HOME else DELAY_LOGIN
        )



    }


    override fun binding(): ViewBinding {
        return ActivitySplashBinding.inflate(layoutInflater)

    }


    private fun loadNextScreen(screen: Screen, delay: Long) {
        /* additional delay to show the splash */
        Handler(Looper.getMainLooper()).postDelayed({
            navigor.navigateTo(screen, null)
        }, delay)

    }

}