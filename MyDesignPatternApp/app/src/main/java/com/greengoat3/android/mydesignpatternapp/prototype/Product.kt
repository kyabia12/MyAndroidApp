package com.greengoat3.android.mydesignpatternapp.prototype

interface Product: Cloneable {
    fun use(s: String)
    fun createClone(): Product
}