package com.example.htetwaiyan.mymvp.view.add_activity

import android.util.Log.d
import com.example.htetwaiyan.mymvp.network.ApiService
import com.example.htetwaiyan.mymvp.utils.BASEURL
import com.example.htetwaiyan.mymvp.utils.KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddPresenterImpl(var view:AddView) : AddPresenter{


    var api:ApiService?=null

    init {
        val retrofit= Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build()
        api=retrofit.create(ApiService::class.java)
    }

    override fun addSubject(subject: String) {
view.showLoading()
        api!!.addSubject(KEY,subject).enqueue(object:Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
                view.hideLoading()
                d("hello123",t.message.toString())

            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                view.hideLoading()
                d("hello123",response.body()!!)
                //"added"
                if(response.body()=="added"){
                    view.displayAddSuccess()
                }

            }

        })


    }



}