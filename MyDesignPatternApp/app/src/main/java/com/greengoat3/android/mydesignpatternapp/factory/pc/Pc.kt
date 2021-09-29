package com.greengoat3.android.mydesignpatternapp.factory.pc

import android.util.Log
import com.greengoat3.android.mydesignpatternapp.factory.factory.Product

class Pc(private val serialNumber: String) : Product() {

    init {
        Log.i("Pc", serialNumber + "のPCを作成します。")
    }

    @Override
    override fun use() {
        Log.i("Pc", serialNumber + "のPCを使います。")
    }

    fun getSerialNumber() : String {
        return serialNumber
    }
}