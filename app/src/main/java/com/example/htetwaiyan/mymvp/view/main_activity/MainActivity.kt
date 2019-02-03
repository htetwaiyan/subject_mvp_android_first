package com.example.htetwaiyan.mymvp.view.main_activity

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.d
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import com.example.htetwaiyan.mymvp.R
import com.example.htetwaiyan.mymvp.model.Subject
import com.example.htetwaiyan.mymvp.view.add_activity.AddActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView{
    var presenter:MainPresenterImpl?=null
    var loading:ProgressDialog?=null



    override fun showError(str: String) {
        Toast.makeText(this,str,Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        loading!!.show()
    }

    override fun hideLoading() {
        if(loading!!.isShowing){
            loading!!.dismiss()
        }
    }

    override fun showData(subjects: List<Subject>) {
        d("getData",subjects.size.toString())
        sadapter!!.setList(subjects)
    }

    var sadapter:SubjectAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter= MainPresenterImpl(this)
        loading= ProgressDialog(this)

        rv_subject_ma.layoutManager= LinearLayoutManager(this)
         sadapter=SubjectAdapter(this)
        rv_subject_ma.adapter=sadapter

        sadapter!!.onSubjectClickListener(object:SubjectDelegate{
            override fun SubjectClick(sub: Subject) {

            }
        })

        presenter!!.fetchSubject()

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId== R.id.add_menu){
            startActivity(Intent(this@MainActivity,AddActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRestart() {
        super.onRestart()
        presenter!!.fetchSubject()
    }
}
