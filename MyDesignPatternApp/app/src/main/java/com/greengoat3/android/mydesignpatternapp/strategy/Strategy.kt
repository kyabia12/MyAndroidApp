package com.greengoat3.android.mydesignpatternapp.strategy

interface Strategy {
    fun nextHand(): Hand
    fun study(win: Boolean)
}