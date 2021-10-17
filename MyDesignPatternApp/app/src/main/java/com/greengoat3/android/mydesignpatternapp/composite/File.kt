package com.greengoat3.android.mydesignpatternapp.composite

import android.util.Log

class File(
    private val name: String,
    private val size: Int
    ): AbstractEntry() {
    override fun getName(): String {
        return name
    }

    override fun getSize(): Int {
        return size
    }

    override fun abstractPrintList(prefix: String) {
        Log.i("File", "$prefix/$this")
    }
}