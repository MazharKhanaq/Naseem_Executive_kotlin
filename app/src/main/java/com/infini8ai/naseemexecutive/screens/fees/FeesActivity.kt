package com.infini8ai.naseemexecutive.screens.fees

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.infini8ai.naseemexecutive.BaseActivity
import com.infini8ai.naseemexecutive.R
import com.infini8ai.naseemexecutive.data.ON_JAN_CLICKED
import com.infini8ai.naseemexecutive.data.impl.IRes
import com.infini8ai.naseemexecutive.data.loginImpl.LoginManager
import com.infini8ai.naseemexecutive.data.prefs.IPref
import com.infini8ai.naseemexecutive.databinding.ActivityFeeBinding

import com.infini8ai.naseemexecutive.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FeesActivity : BaseActivity() {
    lateinit var binding: ActivityFeeBinding
    private val viewModel: FeesViewModel by viewModels()


    //    private val adapter: SchoolFeeRecyclerViewAdapter? = null
    private val progressBar: ProgressBar? = null
//    private val data: ArrayList<Classes>? = null

    //VIews dec
    private var banner: ImageView? = null
    private var mTotalFee: TextView? = null
    private var mSubmitedFee: TextView? = null
    private var mRemaingFee: TextView? = null
    private var mMonth: TextView? = null

    //private TextView mExpenditure,mTotalOutcome;
    private var recyclerView: RecyclerView? = null
    var relativeLayoutjan: RelativeLayout? = null
    var relativeLayoutFeb: RelativeLayout? = null
    var relativeLayoutmarch: RelativeLayout? = null
    var relativeLayoutApril: RelativeLayout? = null
    var relativeLayoutMay: RelativeLayout? = null
    var relativeLayoutJun: RelativeLayout? = null
    var relativeLayoutJuly: RelativeLayout? = null
    var relativeLayoutAug: RelativeLayout? = null
    var relativeLayoutSep: RelativeLayout? = null
    var relativeLayoutOct: RelativeLayout? = null
    var relativeLayoutNov: RelativeLayout? = null
    var relativeLayoutDec: RelativeLayout? = null

    var textViewJan: TextView? = null
    var textViewFeb: TextView? = null
    var textViewMarch: TextView? = null
    var textViewApril: TextView? = null
    var textViewMay: TextView? = null
    var textViewJun: TextView? = null
    var textViewJuly: TextView? = null
    var textViewAug: TextView? = null
    var textViewSep: TextView? = null
    var textViewOct: TextView? = null
    var textViewNov: TextView? = null
    var textViewDec: TextView? = null
    var textViewNoClasses: TextView? = null
    var spinnerYears: Spinner? = null
//    var contentFeeView: ContentFeeBinding? = null
//    mMonth = findViewById<TextView?>(R.id.month_tv)


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

    private fun bindObservers() {
        viewModel.clickEvents.observe(this, Observer {clickEvent ->
            when (clickEvent) {

                ON_JAN_CLICKED->{
                    relativeLayoutjan!!.background =ContextCompat.getDrawable(this@FeesActivity, R.drawable.fullblue_background)
                    textViewJan!!.setTextColor(Color.WHITE)
                    relativeLayoutFeb!!.background = ContextCompat.getDrawable(this@FeesActivity, R.drawable.green_background)
                    textViewFeb!!.setTextColor(Color.parseColor("#00a659"))
                    relativeLayoutmarch!!.background = ContextCompat.getDrawable(this@FeesActivity, R.drawable.green_background)
                    textViewMarch!!.setTextColor(Color.parseColor("#00a659"))
                    relativeLayoutApril!!.background = ContextCompat.getDrawable(this@FeesActivity, R.drawable.green_background)
                    textViewApril!!.setTextColor(Color.parseColor("#00a659"))
                    relativeLayoutMay!!.background = ContextCompat.getDrawable(this@FeesActivity, R.drawable.green_background)
                    textViewMay!!.setTextColor(Color.parseColor("#00a659"))
                    relativeLayoutJun!!.background = ContextCompat.getDrawable(this@FeesActivity, R.drawable.green_background)
                    textViewJun!!.setTextColor(Color.parseColor("#00a659"))
                    relativeLayoutJuly!!.background = ContextCompat.getDrawable(this@FeesActivity, R.drawable.green_background)
                    textViewJuly!!.setTextColor(Color.parseColor("#00a659"))
                    relativeLayoutAug!!.background = ContextCompat.getDrawable(this@FeesActivity, R.drawable.green_background)
                    textViewAug!!.setTextColor(Color.parseColor("#00a659"))
                    relativeLayoutSep!!.background =ContextCompat.getDrawable(this@FeesActivity, R.drawable.green_background)
                    textViewSep!!.setTextColor(Color.parseColor("#00a659"))
                    relativeLayoutOct!!.background = ContextCompat.getDrawable(this@FeesActivity, R.drawable.green_background)
                    textViewOct!!.setTextColor(Color.parseColor("#00a659"))
                    relativeLayoutNov!!.background =ContextCompat.getDrawable(this@FeesActivity, R.drawable.green_background)
                    textViewNov!!.setTextColor(Color.parseColor("#00a659"))
                    relativeLayoutDec!!.background =ContextCompat.getDrawable(this@FeesActivity, R.drawable.green_background)
                    textViewDec!!.setTextColor(Color.parseColor("#00a659"))

                    showMessage("January clicked",ToastType.INFO)


                }
            }
        })
    }

    private fun bindViews() {

        banner = binding.bannerIm
        mTotalFee = binding.totalFeeTv
        mSubmitedFee = binding.collectedFeeTv
        mMonth = binding.monthTv
        mRemaingFee = binding.remainingFeeTv


        recyclerView = binding.recyclerView
        relativeLayoutjan = binding.janmonthRelativelayout
        relativeLayoutFeb = binding.fabmonthRelativelayout
        relativeLayoutmarch = binding.marmonthRelativelayout
        relativeLayoutApril = binding.aprilmonthRelativelayout
        relativeLayoutMay = binding.maymonthRelativelayout
        relativeLayoutJun = binding.junmonthRelativelayout
        relativeLayoutJuly = binding.julymonthRelativelayout
        relativeLayoutAug = binding.augmonthRelativelayout
        relativeLayoutSep = binding.sepmonthRelativelayout
        relativeLayoutOct = binding.octmonthRelativelayout
        relativeLayoutNov = binding.novmonthRelativelayout
        relativeLayoutDec = binding.decmonthRelativelayout

        textViewJan = binding.janmonthTextview
        textViewFeb = binding.fabmonthTextview
        textViewMarch = binding.marmonthTextview
        textViewApril = binding.aprilmonthTextview
        textViewMay = binding.maymonthTextview
        textViewJun = binding.junmonthTextview
        textViewJuly = binding.julymonthTextview
        textViewAug = binding.augmonthTextview
        textViewSep = binding.sepmonthTextview
        textViewOct = binding.octmonthTextview
        textViewNov = binding.novmonthTextview
        textViewDec = binding.decmonthTextview
        textViewNoClasses = binding.noclassesTextview
        spinnerYears = binding.yearsSpinner


    }

    private fun initViewModel() {
        binding = viewBinding as ActivityFeeBinding
        binding.viewModel = viewModel
    }

    override fun binding(): ViewBinding {
        return ActivityFeeBinding.inflate(layoutInflater)

    }
}