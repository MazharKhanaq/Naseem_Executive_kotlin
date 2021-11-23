package com.demo.paging3withroom.network


import com.infini8ai.naseemexecutive.model.requests.SaveUserReqData
import com.infini8ai.naseemexecutive.model.responses.UserRegisterRes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetroServiceInterface {

    @POST("organization")
    fun getorganization(@Body request: SaveUserReqData): Call<UserRegisterRes>

    @POST("schools")
    fun schools(@Body request: SaveUserReqData): Call<UserRegisterRes>


}