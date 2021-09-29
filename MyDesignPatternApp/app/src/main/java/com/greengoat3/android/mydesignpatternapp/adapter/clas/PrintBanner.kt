package com.greengoat3.android.mydesignpatternapp.adapter.clas

class PrintBanner(string: String) : Banner(string), Print {
    override fun printWeak() {
        showWithParen()
    }

    override fun printString() {
        showWithAster()
    }

}