package com.greengoat3.android.mydesignpatternapp.builder

abstract class Builder {
    abstract fun makeTitle(title: String)
    abstract fun makeString(str: String)
    abstract fun makeItems(items: ArrayList<String>)
    abstract fun close()
}