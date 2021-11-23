package com.infini8ai.naseemexecutive.data.signupImpl

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.infini8ai.naseemexecutive.data.FAIlURE
import com.infini8ai.naseemexecutive.data.SUCCSESS
import com.infini8ai.naseemexecutive.data.prefs.IPref
import javax.inject.Inject

class SignUpManagerImpl  @Inject constructor(private val activity: FragmentActivity, val iPref: IPref) : SignUpManager {

    private lateinit var mAuth: FirebaseAuth
    private var myRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("Admin")
    private val events: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }

    override fun initFirebase() {
        mAuth = FirebaseAuth.getInstance()
    }

    override fun SignUpWithEmailAndPassword(email: String, password: String) {

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = mAuth.currentUser
                    if (user != null) {
                        var hashMap : HashMap<String,String> = HashMap<String,String> ()
                        hashMap.put("id",user.uid);
                        hashMap.put("email",email)
                        myRef.child(user.getUid()).setValue(hashMap) .addOnSuccessListener {
                               events.value = SUCCSESS
                        }
                            .addOnFailureListener {
                                Log.d("errro",task.exception.toString())
                              events.value =  FAIlURE
                            }
                    }
                } else {

                    events.value =  FAIlURE

                }
            }

    }

    override fun subscribe(): MutableLiveData<Int>  = events
}