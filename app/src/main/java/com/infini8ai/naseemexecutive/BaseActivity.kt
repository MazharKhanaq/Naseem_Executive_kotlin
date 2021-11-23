package com.infini8ai.naseemexecutive

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import es.dmoral.toasty.Toasty

abstract class BaseActivity : AppCompatActivity() {
    enum class ToastType {
        ERROR,
        SUCCESS,
        INFO
    }

    public lateinit var viewBinding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = binding()
        setContentView(viewBinding.root)
    }

    open fun showMessage(message: String,toastType:ToastType) {
        when(toastType){

            ToastType.ERROR -> {
                Toasty.error(baseContext,  message, Toast.LENGTH_SHORT, true).show()
            }
            ToastType.SUCCESS -> {
                Toasty.success(baseContext,  message, Toast.LENGTH_SHORT, true).show()
            }
            ToastType.INFO -> {
                Toasty.info(baseContext,  message, Toast.LENGTH_SHORT, true).show()
            }
        }



    }

    abstract fun binding(): ViewBinding



}