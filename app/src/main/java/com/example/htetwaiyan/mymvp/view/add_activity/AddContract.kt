package com.example.htetwaiyan.mymvp.view.add_activity

interface AddView{

 fun   showLoading()
 fun   hideLoading()
    fun displayAddSuccess()


}

interface AddPresenter{

   fun addSubject(subject:String)

}