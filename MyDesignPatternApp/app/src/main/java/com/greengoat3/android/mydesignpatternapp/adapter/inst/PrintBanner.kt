package com.greengoat3.android.mydesignpatternapp.adapter.inst

class PrintBanner(
    string: String
    ): Print() {
    private val banner: Banner = Banner(string)

    override fun printWeak() {
        banner.showWithParen()
    }

    override fun printString() {
        banner.showWithAster()
    }
}