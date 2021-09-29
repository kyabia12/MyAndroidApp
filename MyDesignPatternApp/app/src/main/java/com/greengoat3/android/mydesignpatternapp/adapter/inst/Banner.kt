package com.greengoat3.android.mydesignpatternapp.adapter.inst

import android.util.Log

open class Banner(
    private val string: String
    ) {

    fun showWithParen() {
        Log.i("Banner", "(${string})")
    }

    fun showWithAster() {
        Log.i("Banner", "*${string}*")
    }
}