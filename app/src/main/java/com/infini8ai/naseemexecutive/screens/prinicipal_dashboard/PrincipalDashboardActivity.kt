package com.infini8ai.naseemexecutive.screens.prinicipal_dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import com.infini8ai.naseemexecutive.BaseActivity
import com.infini8ai.naseemexecutive.R
import com.infini8ai.naseemexecutive.data.ON_CLICK_FEE_BTN
import com.infini8ai.naseemexecutive.data.ON_INVENTORY_CLICKED
import com.infini8ai.naseemexecutive.data.impl.IRes
import com.infini8ai.naseemexecutive.data.loginImpl.LoginManager
import com.infini8ai.naseemexecutive.data.prefs.IPref
import com.infini8ai.naseemexecutive.databinding.ActivityLoginBinding
import com.infini8ai.naseemexecutive.databinding.ActivityPrincipalDashboardBinding
import com.infini8ai.naseemexecutive.navigator.Navigator
import com.infini8ai.naseemexecutive.navigator.Screen
import com.infini8ai.naseemexecutive.screens.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class PrincipalDashboardActivity : BaseActivity() {
    lateinit var binding: ActivityPrincipalDashboardBinding
    private val viewModel: PrincipalDashbaordViewModel by viewModels()
    private lateinit var feeCardView:CardView
    private lateinit var inventoryCardView:CardView
    private lateinit var classesCardView:CardView
    private lateinit var employeeCardView:CardView
    private lateinit var managerCardView:CardView
    private lateinit var resultCardView:CardView
    private lateinit var expindureCardView:CardView
    private lateinit var principalRequestCardView:CardView
    /* dependency objects */
    @Inject
    lateinit var navigor: Navigator

    @Inject
    lateinit var res: IRes

    @Inject
    lateinit var iPref: IPref

    @Inject
    lateinit var loginManager: LoginManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        bindViews()
        bindObservers()


    }

    private fun bindObservers()
    {
        viewModel.clickEvents.observe(this, Observer {
            when(it){

                ON_CLICK_FEE_BTN->{
                    showMessage("Fee Button Clicked ",ToastType.INFO)

                    navigor.navigateTo(Screen.Fees,null)
                }
                ON_INVENTORY_CLICKED ->{

                    showMessage("Inventory Clicked",ToastType.INFO)
                }


            }
        })



    }

    private fun bindViews()
    {

        feeCardView=binding.feeBtn
        inventoryCardView=binding.inventoryBtn
        classesCardView=binding.classesCd
        employeeCardView=binding.teacherCv
        managerCardView=binding.principalCv
        resultCardView=binding.resultsCv
        expindureCardView=binding.expendituresBtn
        principalRequestCardView=binding.principalRequests


    }

    private fun initViewModel()
    {
        binding = viewBinding as ActivityPrincipalDashboardBinding
        binding.viewModel = viewModel
    }

    override fun binding(): ViewBinding {
        return ActivityPrincipalDashboardBinding.inflate(layoutInflater)
    }


}