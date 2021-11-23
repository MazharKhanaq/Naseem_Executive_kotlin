package com.infini8ai.naseemexecutive.screens.fees

import android.text.format.DateFormat
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infini8ai.naseemexecutive.data.ON_JAN_CLICKED
import com.infini8ai.naseemexecutive.data.impl.IRes
import com.infini8ai.naseemexecutive.data.monthAndYearFormater
import com.infini8ai.naseemexecutive.data.prefs.IPref
import com.infini8ai.naseemexecutive.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


@HiltViewModel
class FeesViewModel @Inject constructor(
    private val repository: RetroRepository, private val res: IRes,
    private val iPref: IPref

) : ViewModel() {

    var textViewJan: ObservableField<String> = ObservableField(String())
    var monthTv: ObservableField<String> = ObservableField(String())

    val totalFee = 0  //Veriables dec
    val submitedFee = 0 //Veriables dec
    val remainingFee = 0 //Veriables dec
    val totalExpenditure = 0
    var currentDate: String? = null
    var selectedYear: String? = null
    var monthNumber: String? = null
    var monthName: String? = null
    var yearNumber: String? = null
    var monthsArray = arrayOf(
        "January", "Feburary", "March", "April", "May",
        "June", "July", "August", "September", "October", "November", "December"
    )
    var yearsArray = arrayOf(
        "2015", "2016", "2017", "2018", "2019",
        "2020", "2021", "2022", "2023", "2024", "2025", "2026"
    )

    init {
        textViewJan.set("Jan")

        currentDate = monthAndYearFormater.format(Date())
        val format = SimpleDateFormat("MM-yyyy")

        var datee: Date? = null
        try {
            datee = format.parse(currentDate)
        } catch (e: ParseException) {
            e.printStackTrace()

            monthName = DateFormat.format("MMMM", datee) as String
            monthNumber = DateFormat.format("MM", datee) as String
            yearNumber = DateFormat.format("yyyy", datee) as String
        }

    }

    var yearSelectListener: AdapterView.OnItemSelectedListener =
        object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item: Any = parent.getItemAtPosition(position).toString()
                selectedYear = item.toString()
                Log.i("TAG", "onItemSelected: $selectedYear")


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    fun onJanClick() {
        clickEvents.value = ON_JAN_CLICKED
        textViewJan.set("Jan")
        monthNumber = "01"
        monthName = monthsArray[0]
        monthTv.set(monthName)
        currentDate = "$monthNumber-$selectedYear"
        Log.e("TAG", "onJanClick: "+ currentDate )



    }






    val clickEvents: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }


}