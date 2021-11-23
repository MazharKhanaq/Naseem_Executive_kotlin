package com.infini8ai.naseemexecutive.screens.login

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import com.google.firebase.FirebaseApp
import com.infini8ai.naseemexecutive.BaseActivity
import com.infini8ai.naseemexecutive.R
import com.infini8ai.naseemexecutive.data.*
import com.infini8ai.naseemexecutive.data.impl.IRes
import com.infini8ai.naseemexecutive.data.loginImpl.LoginManager
import com.infini8ai.naseemexecutive.data.prefs.IPref
import com.infini8ai.naseemexecutive.databinding.ActivityLoginBinding
import com.infini8ai.naseemexecutive.model.Organization

import com.infini8ai.naseemexecutive.navigator.Navigator
import com.infini8ai.naseemexecutive.navigator.Screen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity() {

    lateinit var loginBinding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    lateinit var email: EditText
    lateinit var password: EditText


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

        FirebaseApp.initializeApp(this);
        loginManager.initFirebase()
        initViewModel()
        bindViews()
        bindObservers()




    }

    private fun bindViews() {
        email = loginBinding.emailEt
        password = loginBinding.passwordEt

    }

    override fun binding(): ViewBinding {


        return ActivityLoginBinding.inflate(layoutInflater)
    }

    private fun initViewModel() {
        loginBinding = viewBinding as ActivityLoginBinding
        loginBinding.viewModel = viewModel
    }

    private fun bindObservers() {
        loginBinding?.viewModel?.signUpEvent?.observe(this, Observer {
            when (it) {
                ON_CLICK_LOGIN_IN -> {
                    if (validate()) { loginManager.loginWithEmailAndPassword(
                            viewModel.email.get()!!,
                            viewModel.password.get()!!
                        )


                    } else {
                        viewModel.updateLoading()
                    }

                }

                ON_CLICK_SIGN_UP -> {
                    navigor.navigateTo(Screen.Sign_up, null)
                }

            }
        })

        loginManager.subscribe().observe(this, Observer { event ->
            when (event) {

                USER_EXISTS -> {
                    getOrganization()
                }
                USER_NOT_EXISTS -> {
                    showMessage(res.str(R.string.account_does_not_exist), ToastType.INFO)
                    viewModel.updateLoading()

                }
                LOGIN_FAILED -> {
                    showMessage(res.str(R.string.bad_response), ToastType.ERROR);
                    viewModel.updateLoading()


                }

            }
        })

    }

    private fun getOrganization() {
        viewModel.getOrganization().observe(this, Observer { response ->

            if (response == null) {
                showMessage(res.str(R.string.bad_response), ToastType.ERROR)
                Log.e("TAG", "response bad : " + response?.code())
                return@Observer
            }
            if (response.body()?.response?.status?.statusCode == 200) {
                val organzation: Organization? = response.body()?.response?.data?.organization

                if (organzation != null && !organzation.disabled) {
                    showMessage(res.str(R.string.successfully_login), ToastType.SUCCESS)
                    iPref.put(KEY_USER_LOGIN, true)
                    iPref.put(ORGANIZATION_ID,organzation._id)
                    navigor.navigateTo(Screen.HOME, null)
                    viewModel.updateLoading()
                }
                else{
                    showMessage(res.str(R.string.you_are_not_allowed),ToastType.INFO)
                }

            } else {
                showMessage(
                    response.body()?.response?.status?.statusMessage.toString(),
                    ToastType.INFO
                )

            }


        })
    }


    override fun onResume() {
        super.onResume()
        if (iPref.bool(KEY_USER_LOGIN))
            navigor.navigateTo(Screen.HOME, null)

    }

    fun validate(): Boolean {
        if (viewModel.email.get().equals("") || viewModel.email.get() == null) {
            email.error = res.str(R.string.enter_your_email)
            return false
        } else if (viewModel.password.get().equals("") || viewModel.password.get() == null) {
            password.error = res.str(R.string.enter_password)
            return false
        } else {
            return true
        }

    }
}