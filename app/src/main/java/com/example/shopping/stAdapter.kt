package com.example.shop

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.security.cert.CertPath

class stAdapter : RecyclerView.Adapter<stAdapter.Companion.Holder>{

    companion object{

        class Holder : RecyclerView.ViewHolder
        {
            lateinit var tvName: TextView
            lateinit var imgPath: ImageView

            constructor(rv: View) : super (rv){
                imgPath = rv.findViewById(R.id.image_view) as ImageView
                tvName = rv.findViewById(R.id.first_text) as TextView
            }
        }
    }

    var list: MutableList<student> = mutableListOf()

    lateinit var con: Context
    constructor(list: MutableList<student>, con: Context ) : super() {
        this.list = list
        this.con = con
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var rv: View
        var holder: Holder
        rv = LayoutInflater.from(parent!!.context).inflate(R.layout.example_item, parent, false )
        holder = Holder(rv)
        return holder
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        var st: student
        st = list.get(position)
        holder!!.tvName.setText(st.getSname())
        holder!!.imgPath.setImageResource(st.getPath())

    }
    override fun getItemCount(): Int {

        return list.size
    }


}