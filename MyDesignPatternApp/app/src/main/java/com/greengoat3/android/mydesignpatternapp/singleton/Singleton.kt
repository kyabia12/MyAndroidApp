package com.greengoat3.android.mydesignpatternapp.singleton

import android.util.Log

class Singleton {
    companion object {
        private  val singleton:Singleton = Singleton()

        fun getInstance(): Singleton {
            return singleton
        }
    }

    init {
        Log.i("Singleton", "インスタンスを生成しました。")
    }
}