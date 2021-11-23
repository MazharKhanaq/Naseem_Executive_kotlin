package com.infini8ai.naseemexecutive.data.loginImpl

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.infini8ai.naseemexecutive.data.USER_EXISTS
import com.infini8ai.naseemexecutive.data.USER_NOT_EXISTS
import com.infini8ai.naseemexecutive.data.prefs.IPref
import javax.inject.Inject

class LoginMangerImpl @Inject constructor(private val activity: FragmentActivity, val iPref: IPref) : LoginManager {
    private lateinit var mAuth: FirebaseAuth
    private val events: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }

    override fun initFirebase() {
        mAuth = FirebaseAuth.getInstance()
    }

    override fun loginWithEmailAndPassword(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = mAuth.currentUser
                    events.value = USER_EXISTS



                } else {
                    events.value = USER_NOT_EXISTS
                }
            }
    }

    override fun subscribe(): MutableLiveData<Int> = events
}