package com.example.shopping

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*


class stAdapter : RecyclerView.Adapter<stAdapter.Companion.Holder>{

    companion object{

        class Holder : RecyclerView.ViewHolder
        {
            lateinit var tvName: TextView
            lateinit var imgPath: ImageView
            lateinit var cardView: CardView

            constructor(rv: View) : super (rv){
                imgPath = rv.findViewById(R.id.image_view) as ImageView
                tvName = rv.findViewById(R.id.first_text) as TextView
                cardView = rv.findViewById(R.id.cardie) as CardView

                cardView.setOnClickListener(object : View.OnClickListener{
                    override fun onClick(v: View?) {
                        mListener.onItemClick()
                    }
                })
            }
        }
    }

    var list: MutableList<student> = mutableListOf()

    lateinit var con: Context
    lateinit var mListener: ItemClickListener
    constructor(list: MutableList<student>, con: Context, listener: ItemClickListener) : super() {
        this.list = list
        this.con = con
        this.mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): Holder {
        var rv: View
        var holder: Holder
        rv = LayoutInflater.from(parent!!.context).inflate(R.layout.example_item, parent, false )
        holder = Holder(rv)

        return holder
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val st: student
        st = list.get(position)
        holder!!.tvName.text = st.getSname()
        holder!!.imgPath.setImageResource(st.getPath())


    }
    override fun getItemCount(): Int {

        return list.size
    }



}
interface ItemClickListener {
    fun onItemClick(item: student, position: Int)
}


}