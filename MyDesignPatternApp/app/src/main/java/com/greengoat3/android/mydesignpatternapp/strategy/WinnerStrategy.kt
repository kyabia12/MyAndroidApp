package com.greengoat3.android.mydesignpatternapp.strategy

class WinnerStrategy: Strategy {
    private var won: Boolean = false
    private val range = (0..2)
    private lateinit var prevHand: Hand
    override fun nextHand(): Hand {
        if (!won) {
            prevHand = Hand.hand[range.random()]
        }
        return prevHand
    }

    override fun study(win: Boolean) {
        won = win
    }
}