package com.greengoat3.android.mydesignpatternapp.composite

import android.util.Log

class Directory(
    private val name: String
    ): AbstractEntry() {
    private val directory: ArrayList<AbstractEntry> = ArrayList()

    override fun getName(): String {
        return name
    }

    override fun getSize(): Int {
        var size = 0
        val it: Iterator<AbstractEntry> = directory.iterator()

        while (it.hasNext()) {
            val entry: AbstractEntry = it.next()
            size += entry.getSize()
        }
        return size
    }

    override fun abstractPrintList(prefix: String) {
        Log.i("Directory", "$prefix/$this")
        val it: Iterator<AbstractEntry> = directory.iterator()

        while (it.hasNext()) {
            val entry: AbstractEntry = it.next()
            entry.abstractPrintList("$prefix/$name")
        }
    }

    override fun add(entry: AbstractEntry): AbstractEntry {
        directory.add(entry)
        return this
    }
}