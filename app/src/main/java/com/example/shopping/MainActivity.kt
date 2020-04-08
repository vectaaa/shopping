package com.example.shopping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.stAdapter
import com.example.shop.student
import com.example.shopping.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var list: MutableList<student> = mutableListOf()
    lateinit var layoutManager: RecyclerView.LayoutManager

    var img_id: IntArray = intArrayOf(R.drawable.shirtt, R.drawable.laptop,R.drawable.bags )

    var sname: Array<String> = arrayOf("Clothing", "Computing", "Bags")

    lateinit var adapter: stAdapter

    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        var count: Int = 0
        for (name: String in sname) {
            var c: student = student(sname[count], img_id[count])
            list.add(c)
            count++
        }

        adapter = stAdapter(list,this)
        recyclerView.adapter = adapter

    }}
