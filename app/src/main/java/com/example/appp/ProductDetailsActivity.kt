package com.example.appp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.appp.databinding.ActivityProductDetailsBinding
import kotlinx.android.synthetic.main.activity_product_details.*
import kotlinx.android.synthetic.main.activity_product_details.productdescription
import kotlinx.android.synthetic.main.activity_product_details.productname
import kotlinx.android.synthetic.main.layout_item_view.*

class ProductDetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_product_details)

        productname.text = getIntent().getStringExtra("PRODUCTNAME")
        productdescription.text = getIntent().getStringExtra("PRODUCTDESC")
        productprice.text = getIntent().getStringExtra("PRODUCTPRICE")
        product_image.setImageResource(getIntent().getStringExtra("PRODUCTIMG").toInt())

    }
}
