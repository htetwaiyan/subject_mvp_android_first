package com.example.htetwaiyan.mymvp.view.main_activity

import com.example.htetwaiyan.mymvp.model.Subject

interface MainPresenter{

   fun fetchSubject()
    fun deleteSubject(id:String)

}

interface MainView {

    fun showLoading()
    fun hideLoading()
    fun showData(subjects:List<Subject>)
    fun showError(str:String)

}