package com.example.htetwaiyan.mymvp.view.add_activity

import android.app.ProgressDialog
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.htetwaiyan.mymvp.R
import kotlinx.android.synthetic.main.add_activity.*


class AddActivity :AppCompatActivity(), AddView{
    override fun displayAddSuccess() {
        finish()
    }

    var pd:ProgressDialog?=null

    override fun showLoading() {
        pd!!.show()
    }

    override fun hideLoading() {
        if(pd!!.isShowing){
            pd!!.dismiss()
        }
    }

    var presenter:AddPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity)
        pd=ProgressDialog(this)
        pd!!.setMessage("Loading")

        presenter=AddPresenterImpl(this)

        btn_add_aa.setOnClickListener {
            var subject=et_add_aa.text.toString()
            presenter!!.addSubject(subject)
        }

    }

}