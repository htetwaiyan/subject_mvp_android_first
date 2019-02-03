package com.example.htetwaiyan.mymvp.network

import com.example.htetwaiyan.mymvp.model.SubjectResponse
import com.example.htetwaiyan.mymvp.repositories.SubjectRepository
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface ApiService {

//    @POST("subject")
//    Call<SubjectResponse> getSubject(@Field("secrete")String ApiKey)


    @FormUrlEncoded
    @POST("subject")
    fun getSubject(@Field("secrete")apikey:String) : Call<SubjectResponse>



    @FormUrlEncoded
@POST("subject/add")
fun addSubject(@Field("secrete")apikey: String,@Field("name")subject:String):Call<String>

    //int a=10;
    //var a:Int=10;

    @FormUrlEncoded
    @POST("subject/delete")
    fun deleteSubject(@Field("secrete")apikey: String,@Field("id")id:String):Call<String>



}