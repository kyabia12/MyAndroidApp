package com.greengoat3.android.mydesignpatternapp.prototype

import android.util.Log

class UnderlinePen(
    val ulchar: Char
    ) : Product {

    override fun use(s: String) {
        Log.i("UnderlinePen", "$ulchar\\$s\\$ulchar")
    }

    override fun createClone(): Product {
        var p: Product? = null
        try {
            p = clone() as Product
        } catch (e: CloneNotSupportedException) {
            Log.e("UnderlinePen", e.toString())
        }
        return p!!;
    }

}