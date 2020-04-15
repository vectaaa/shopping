package com.example.appp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnProductItemClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var productlist: ArrayList<Products>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        productlist = ArrayList()
        addProducts()

        productRecycler.layoutManager = LinearLayoutManager(this)
        productRecycler.addItemDecoration(DividerItemDecoration(this, 1))
        productRecycler.adapter = ProductAdapter(productlist, this)
    }

    fun addProducts(){
        productlist.add(Products("Polo Ralph Lauren", "Beautiful polo which matches and fits you every time and place. For parties, launcheon, dates, etc.","NGN5000",  R.drawable.shirtt))
        productlist.add(Products("Classic School Bags", "Beautiful polo which matches and fits you every time and place. For parties, launcheon, dates, etc.","NGN3000",  R.drawable.bags))
        productlist.add(Products("Hp Computers", "Beautiful polo which matches and fits you every time and place. For parties, launcheon, dates, etc.","NGN85000",  R.drawable.laptop))
        productlist.add(Products("Skmei WristWatch", "Beautiful polo which matches and fits you every time and place. For parties, launcheon, dates, etc.","NGN5000",  R.drawable.wrist))
        productlist.add(Products("Leather Shoes", "Beautiful polo which matches and fits you every time and place. For parties, launcheon, dates, etc.","NGN10000",  R.drawable.maleshoes))
        productlist.add(Products("Top Heels", "Beautiful polo which matches and fits you every time and place. For parties, launcheon, dates, etc.","NGN5000",  R.drawable.heels))
        productlist.add(Products("Denim Skirt", "Beautiful polo which matches and fits you every time and place. For parties, launcheon, dates, etc.","NGN5000",  R.drawable.skirt))
    }

    override fun onItemClick(item: Products, position: Int) {
        // Toast.makeText(this, item.name, Toast.LENGTH_SHORT ).show()
        val intent = Intent(this, ProductDetailsActivity::class.java)
        intent.putExtra("PRODUCTNAME", item.name)
        intent.putExtra("PRODUCTDESC", item.description)
        intent.putExtra("PRODUCTPRICE", item.price)
        intent.putExtra("PRODUCTIMG", item.image.toString())
        startActivity(intent)
    }
}
