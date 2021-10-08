package com.greengoat3.android.mydesignpatternapp.abstractFactory.listfactory

import com.greengoat3.android.mydesignpatternapp.abstractFactory.factory.AbstractItem
import com.greengoat3.android.mydesignpatternapp.abstractFactory.factory.AbstractTray

class ListTray(
    caption:String
): AbstractTray(caption) {
    override fun makeHTML(): String {
        var buffer = ""
        buffer += caption
        val it: MutableIterator<AbstractItem> = tray.iterator()

        while (it.hasNext()) {
            val item: AbstractItem = it.next()
            buffer += " ${item.makeHTML()}"
        }

        return buffer
    }
}