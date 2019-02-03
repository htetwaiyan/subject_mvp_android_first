package com.example.htetwaiyan.mymvp.view.main_activity

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.htetwaiyan.mymvp.R
import com.example.htetwaiyan.mymvp.model.Subject
import kotlinx.android.synthetic.main.sample_view.view.*

class SubjectAdapter(var ctxt: Context): RecyclerView.Adapter<SubjectAdapter.SubjectHolder>() {

    var subjects:List<Subject> =ArrayList<Subject>()//0

    var delegate:SubjectDelegate?=null

    fun onSubjectClickListener(delegate: SubjectDelegate){
        this.delegate=delegate
    }

    fun setList(subjects:List<Subject>){
        this.subjects=subjects
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): SubjectHolder {
        var view=LayoutInflater.from(ctxt).inflate(R.layout.sample_view,parent,false)
        return SubjectHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectHolder, position: Int) {
        var sub=subjects[position]
        holder.itemView.tv_sv.text=sub.name
        holder.itemView.setOnClickListener{
            delegate!!.SubjectClick(sub)
        }
    }

    override fun getItemCount(): Int {
        return subjects.size

    }


    inner class SubjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


//class SubjectHolder extends RecyclerView.ViewHolder{
//SubjectHolder(View itemView){
//    super(itemView)

}