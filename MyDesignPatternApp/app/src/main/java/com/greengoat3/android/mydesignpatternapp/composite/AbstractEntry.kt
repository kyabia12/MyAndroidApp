package com.greengoat3.android.mydesignpatternapp.composite

abstract class AbstractEntry {
    abstract fun getName(): String

    abstract fun getSize(): Int

    open fun add(entry: AbstractEntry): AbstractEntry {
        throw FileTreatmentException()
    }

    fun printList() {
        abstractPrintList("")
    }

    abstract fun abstractPrintList(prefix: String)

    override fun toString(): String {
        return getName() + " (${getSize()})"
    }
}