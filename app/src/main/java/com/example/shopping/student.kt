package com.example.shop

class student {

    private lateinit var sname: String
    private var img_path: Int = 0

    constructor(sname: String, img_path: Int) {
        this.setPath(img_path)
        this.setSname(sname)
    }

    fun getSname() : String
    {
        return sname
    }
    fun setSname(sname: String)
    {
        this.sname = sname
    }
    fun getPath() : Int
    {
        return img_path
    }
    fun setPath(path: Int)
    {
        img_path= path
    }
}