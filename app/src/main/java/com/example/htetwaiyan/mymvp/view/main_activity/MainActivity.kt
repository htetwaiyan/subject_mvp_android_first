package com.example.htetwaiyan.mymvp.view.main_activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.htetwaiyan.mymvp.R
import com.example.htetwaiyan.mymvp.view.add_activity.AddActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}
