package com.example.htetwaiyan.mymvp.view.main_activity

import com.example.htetwaiyan.mymvp.model.SubjectResponse
import com.example.htetwaiyan.mymvp.network.ApiService
import com.example.htetwaiyan.mymvp.utils.BASEURL
import com.example.htetwaiyan.mymvp.utils.KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainPresenterImpl(var mv:MainView) : MainPresenter{
    override fun deleteSubject(id: String) {
        mv.showLoading()
        api!!.deleteSubject(KEY,id).enqueue(object:Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
                mv.hideLoading()
                mv.showError(t.message.toString())
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                mv.hideLoading()
                if(response.body()=="deleted"){
                    fetchSubject()
                }

            }

        })


    }

    var api:ApiService?=null


    init {
        var retrofit= Retrofit.Builder().baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        api=retrofit.create(ApiService::class.java)
    }


    override fun fetchSubject() {
        mv.showLoading()
        api!!.getSubject(KEY).enqueue(object:Callback<SubjectResponse>{
            override fun onFailure(call: Call<SubjectResponse>, t: Throwable) {
                mv.hideLoading()
                mv.showError(t.message.toString())
            }

            override fun onResponse(call: Call<SubjectResponse>, response: Response<SubjectResponse>) {
                mv.hideLoading()
                if(response.isSuccessful){
                    mv.showData(response.body()!!.subjects!!)
                }
            }

        })

    }


}