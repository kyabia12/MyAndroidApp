package com.greengoat3.android.mydesignpatternapp.builder

class HTMLBuilder: Builder() {
    private var buffer = ""
    override fun makeTitle(title: String) {
        buffer += "=========================\n"
        buffer += "[$title]\n"
        buffer += "\n"
    }

    override fun makeString(str: String) {
        buffer += "* $str\n"
        buffer += "\n"
    }

    override fun makeItems(items: ArrayList<String>) {
        for (i in 0..items.size) {
            buffer += items[i]
        }
        buffer += "\n"
    }

    override fun close() {
        buffer += "=========================\n"
    }

    fun getResult(): String {
        return buffer
    }
}