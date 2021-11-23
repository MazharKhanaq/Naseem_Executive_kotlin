package com.infini8ai.naseemexecutive.screens.schools

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.infini8ai.naseemexecutive.BaseActivity
import com.infini8ai.naseemexecutive.data.ON_CLICK_CREATE_ORGANIZATION
import com.infini8ai.naseemexecutive.data.ORGANIZATION_ID
import com.infini8ai.naseemexecutive.data.impl.IRes
import com.infini8ai.naseemexecutive.data.loginImpl.LoginManager
import com.infini8ai.naseemexecutive.data.prefs.IPref
import com.infini8ai.naseemexecutive.databinding.ActivityOrganizationSchoolBinding
import com.infini8ai.naseemexecutive.model.School
import com.infini8ai.naseemexecutive.navigator.Navigator
import com.infini8ai.naseemexecutive.navigator.Screen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OrganizationSchoolActivity : BaseActivity() {
    lateinit var binding:ActivityOrganizationSchoolBinding
    private val viewModel: SchoolsViewModel by viewModels()
    private lateinit var schoolsAdapter: SchoolsAdapter
    private lateinit var schoolList: ArrayList<School>
    private lateinit var recyclerView: RecyclerView

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
        initAdapterAndRecyclerView()

    }

    override fun binding(): ViewBinding {
        return  ActivityOrganizationSchoolBinding.inflate(layoutInflater)
    }

    private fun initViewModel() {
        binding = viewBinding as ActivityOrganizationSchoolBinding
        binding.viewModel = viewModel
    }

    private fun bindViews() {
        recyclerView=binding.recyclerView

    }


    fun bindObservers() {
        binding?.viewModel?.onClickEvents?.observe(this, {
            when (it) {
                ON_CLICK_CREATE_ORGANIZATION -> {
//                    navigor.navigateTo(Screen.ORGANIZATION,null);

                }

            }
        })

    }

    private fun initAdapterAndRecyclerView() {
        schoolList = ArrayList<School>()

        recyclerView.apply {
            layoutManager = GridLayoutManager(this@OrganizationSchoolActivity,2)
            schoolsAdapter = SchoolsAdapter(this@OrganizationSchoolActivity)
            schoolsAdapter.setOrganizationList(schoolList)
            schoolsAdapter.setOnClickMenuListener(mOnClickRowSchoolListener)
            adapter = schoolsAdapter



        }
    }

    private val mOnClickRowSchoolListener: SchoolsAdapter.OnClickRowSchoolListener =
        object : SchoolsAdapter.OnClickRowSchoolListener {
            override fun onClickSchools(position: Int, school: School?) {
                navigor.navigateTo(Screen.PRINICIPAL_DASHBAORD, school)

            }
        }

    private fun getData() {

        viewModel.getSchools(organizationId =iPref.str(ORGANIZATION_ID)).observe(this, { response ->

            if (response == null) {

                viewModel.updateLoading()
                return@observe

            }
            if (response.body()?.response?.status?.statusCode == 200) {

                schoolList.clear()

                response.body()?.response?.data?.schools?.let { schools ->

                    schoolList.addAll(schools)

                }

                schoolsAdapter.setOrganizationList(schoolList)

                schoolsAdapter.notifyDataSetChanged()

                if (schoolList.isNotEmpty()) {
                    viewModel.updateOrganizations(true)
                }

                viewModel.updateLoading()
            } else {
                showMessage(
                    response.body()?.response?.status?.statusMessage.toString(),
                    ToastType.ERROR
                )
                viewModel.updateLoading()
            }

        })

    }
    override fun onResume() {
        super.onResume()
        getData()
    }

}