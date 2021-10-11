package com.greengoat3.android.mydesignpatternapp.strategy

class Hand(
    private val handValue: Pattern
    ) {
    companion object {
        enum class Pattern(val hand: Int,
                          val handName: String) {
            GUU(0, "グー"),
            CHO(1, "チョキ"),
            PAR(2, "パー")
        }

        val hand:Array<Hand> = arrayOf(
            Hand(Pattern.GUU),
            Hand(Pattern.CHO),
            Hand(Pattern.PAR)
        )

    }

    fun isStrongerThan(h: Hand): Boolean {
        return fight(h) == 1
    }

    fun isWeakerThan(h: Hand): Boolean {
        return fight(h) == -1
    }

    private fun fight(h: Hand): Int {
        if (this == h) {
            return 0
        } else if ((this.handValue.hand + 1) % 3 == h.handValue.hand) {
            return 1
        } else {
            return -1
        }
    }

    override fun toString(): String {
        return handValue.handName
    }
}