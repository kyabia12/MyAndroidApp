package com.greengoat3.android.mydesignpatternapp.strategy

class ProbStrategy: Strategy {
    private var prevHandValue: Int = 0
    private var currentHandValue: Int = 0
    private var history: Array<Array<Int>> = Array(3) { Array(3) { 1 } }

    override fun nextHand(): Hand {
        val max = getSum(currentHandValue)
        val bet = (0..max).random()
        val handValue: Int

        if (bet < history[currentHandValue][0]) {
            handValue = 0
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handValue = 1
        } else {
            handValue = 2
        }

        prevHandValue = currentHandValue
        return Hand.hand[handValue]
    }

    override fun study(win: Boolean) {
        if (win) {
            history[prevHandValue][currentHandValue]++
        } else {
            history[prevHandValue][(currentHandValue + 1) % 3 ]++
            history[prevHandValue][(currentHandValue + 2) % 3 ]++
        }
    }

    private fun getSum(hv: Int): Int {
        var sum = 0
        for (i in 0 until 3) {
            sum += history[hv][i]
        }
        return sum
    }
}