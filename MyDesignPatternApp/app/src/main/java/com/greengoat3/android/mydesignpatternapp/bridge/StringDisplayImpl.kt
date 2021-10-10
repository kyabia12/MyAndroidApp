package com.greengoat3.android.mydesignpatternapp.bridge

import android.util.Log

class StringDisplayImpl(
    private val string: String,
): DisplayImpl(){

    private val width = string.toByteArray().size
    private var buffer: String = ""

    override fun rawOpen() {
        buffer = ""
        printLine()
    }

    override fun rawPrint() {
        buffer += "|$string|\n"
    }

    override fun rawClose() {
        printLine()
        Log.i("StringDisplayImpl", buffer)
    }

    private fun printLine() {
        buffer += "+"
        for (i in 0 until width) {
            buffer += "-"
        }
        buffer += "+\n"
    }
}