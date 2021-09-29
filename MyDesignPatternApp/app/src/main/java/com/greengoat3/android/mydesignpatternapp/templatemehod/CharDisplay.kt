package com.greengoat3.android.mydesignpatternapp.templatemehod

import android.util.Log

class CharDisplay(private val char: Char) : AbstractDisplay() {
    override fun open() {
        Log.i("CharDisplay","<<")
    }

    override fun print() {
        Log.i("CharDisplay","$char")
    }

    override fun close() {
        Log.i("CharDisplay",">>")
    }
}