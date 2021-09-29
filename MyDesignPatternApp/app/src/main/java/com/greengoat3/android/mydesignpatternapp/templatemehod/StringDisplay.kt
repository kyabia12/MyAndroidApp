package com.greengoat3.android.mydesignpatternapp.templatemehod

import android.util.Log

class StringDisplay(
    private val string: String
    ): AbstractDisplay() {
    private val _width = string.toByteArray().size
    override fun open() {
        printLine()
    }

    override fun print() {
        Log.i("StringDisplay", "|$string|")
    }

    override fun close() {
        printLine()
    }

    private fun printLine() {
        Log.i("StringDisplay", "+")
        for (i in 0.._width) {
            Log.i("StringDisplay", "--")
        }
        Log.i("StringDisplay", "+")
    }
}