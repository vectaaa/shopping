package com.example.appp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_product_details.view.*
import kotlinx.android.synthetic.main.layout_item_view.view.*
import kotlinx.android.synthetic.main.layout_item_view.view.productdescription
import kotlinx.android.synthetic.main.layout_item_view.view.productname

class ProductAdapter(var items: ArrayList<Products>, var clickListener: OnProductItemClickListener) : RecyclerView.Adapter<ProductViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        lateinit var productViewHolder: ProductViewHolder
        productViewHolder = ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view, parent, false))
        return productViewHolder
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        //holder.productsName?.text = items.get(position).name
       //holder.productsDescription?.text = items.get(position).description
        //holder.productsImage?.setImageResource(items.get(position).image)
        holder.initialize(items.get(position), clickListener)
    }
}

class ProductViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
    var productsName = itemView.productname
    var productsDescription = itemView.productdescription
    var productsImage = itemView.productimage


    fun initialize(item: Products, action: OnProductItemClickListener){
        productsName.text = item.name
        productsDescription.text = item.description
        productsImage.setImageResource(item.image)

        itemView.setOnClickListener {
            action.onItemClick(item, adapterPosition )
        }
    }
}

interface OnProductItemClickListener{
    fun onItemClick(item: Products, position: Int)
}