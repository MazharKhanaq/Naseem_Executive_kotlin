package com.infini8ai.naseemexecutive.navigator

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.infini8ai.naseemexecutive.data.SCHOOL_OBJECT
import com.infini8ai.naseemexecutive.model.School
import com.infini8ai.naseemexecutive.screens.fees.FeesActivity
import com.infini8ai.naseemexecutive.screens.login.LoginActivity
import com.infini8ai.naseemexecutive.screens.prinicipal_dashboard.PrincipalDashboardActivity
import com.infini8ai.naseemexecutive.screens.schools.OrganizationSchoolActivity
import com.infini8ai.naseemexecutive.screens.splash.SplashActivity
import javax.inject.Inject

/**
 * Class used to navigate from one page to another.
 * It uses screen code.
 * */
class NavigatorImpl @Inject constructor(private val activity: FragmentActivity) : Navigator {
    override fun navigateTo(screen: Screen, type: Any?) {

        when (screen) {

            Screen.LOGIN -> {
                activity.startActivity(Intent(activity, LoginActivity::class.java))

            }

            Screen.Sign_up-> {

            }

            Screen.SPLASH -> {
                activity.startActivity(Intent(activity, SplashActivity::class.java))


            }

            Screen.HOME -> {
                activity.startActivity(Intent(activity, OrganizationSchoolActivity::class.java))
            }


            Screen.PRINICIPAL_DASHBAORD -> {
                val intent: Intent =Intent(activity, PrincipalDashboardActivity::class.java)
                if (type is School) {
                    intent.putExtra(SCHOOL_OBJECT, type)
                    activity.startActivity(intent)
                }
            }

            Screen.Fees -> {
                val intent: Intent =Intent(activity, FeesActivity::class.java)
                activity.startActivity(intent)

//                if (type is School) {
//                    intent.putExtra(SCHOOL_OBJECT, type)
//                }
            }






            }
        }

}