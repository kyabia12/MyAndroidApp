package com.greengoat3.android.mydesignpatternapp.prototype

import android.util.Log

class MessageBox(
    private val decochar: Char
    ): Product {
    override fun use(s: String) {
        Log.i("MassageBox", decochar + s + decochar)
    }

    override fun createClone():Product {
        var p: Product? = null
        try {
            p = clone() as Product
        } catch (e: CloneNotSupportedException) {
            Log.i("MassageBox",e.toString())
        }
        return p!!
    }
}