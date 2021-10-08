package com.greengoat3.android.mydesignpatternapp.abstractFactory.factory

import android.util.Log

abstract class AbstractPage(
    protected val title: String,
    protected val author: String
    ) {
    protected val content: ArrayList<AbstractItem> = arrayListOf()

    fun add(item: AbstractItem) {
        content.add(item)
    }

    fun output() {
        Log.i("AbstractPage", "${title}.htmlを作成しました。")
        Log.i("AbstractPage", makeHTML())
    }
    abstract fun makeHTML(): String
}