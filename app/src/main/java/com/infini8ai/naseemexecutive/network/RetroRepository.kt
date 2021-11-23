package com.infini8ai.naseemexecutive.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.demo.paging3withroom.network.RetroServiceInterface
import com.infini8ai.naseemexecutive.data.GET_ORGANIZATION_FOR_LOGIN
import com.infini8ai.naseemexecutive.data.GET_SCHOOL_BY_ORGANIZATION
import com.infini8ai.naseemexecutive.model.requests.Data
import com.infini8ai.naseemexecutive.model.responses.UserRegisterRes
import com.infini8ai.naseemexecutive.model.requests.Request
import com.infini8ai.naseemexecutive.model.requests.SaveUserReqData

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository  @Inject constructor(private val retroServiceInterface: RetroServiceInterface) {
    private lateinit var apiResponse: MutableLiveData<Response<UserRegisterRes>>



    fun getOrganizationForLogin(id: String?, password: String?): LiveData<Response<UserRegisterRes>> {

        apiResponse = MutableLiveData()
        val data = Data(_id = id)

        val request: Request = Request(GET_ORGANIZATION_FOR_LOGIN,data)

        val userReqData = SaveUserReqData(request)

        val call: Call<UserRegisterRes> = userReqData.let { retroServiceInterface.getorganization(it) }

        call.enqueue(object : Callback<UserRegisterRes> {
            override fun onResponse(call: Call<UserRegisterRes>, response: Response<UserRegisterRes>) {
                if (response.isSuccessful) {
                    val userRegisterRes = response
                    apiResponse.value = userRegisterRes
                }
            }

            override fun onFailure(call: Call<UserRegisterRes>, t: Throwable) {
                apiResponse.value = null
            }
        })

        return apiResponse
    }


    /*API call to get Schools*/

    fun getSchools(id: String): LiveData<Response<UserRegisterRes>> {

        apiResponse = MutableLiveData()

        val data = Data(organization_id = id)

        val request: Request = Request(GET_SCHOOL_BY_ORGANIZATION, data)

        val userReqData = SaveUserReqData(request)

        val call: Call<UserRegisterRes> = userReqData.let { retroServiceInterface.schools(it) }

        call.enqueue(object : Callback<UserRegisterRes> {
            override fun onResponse(
                call: Call<UserRegisterRes>,
                response: Response<UserRegisterRes>) {
                if (response.isSuccessful) {
                    val userRegisterRes = response
                    apiResponse.value = userRegisterRes
                }
            }

            override fun onFailure(call: Call<UserRegisterRes>, t: Throwable) {
                apiResponse.value = null
            }
        })

        return apiResponse
    }

}