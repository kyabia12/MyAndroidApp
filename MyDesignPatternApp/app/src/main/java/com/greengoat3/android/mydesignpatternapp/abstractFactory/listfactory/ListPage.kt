package com.greengoat3.android.mydesignpatternapp.abstractFactory.listfactory

import com.greengoat3.android.mydesignpatternapp.abstractFactory.factory.AbstractItem
import com.greengoat3.android.mydesignpatternapp.abstractFactory.factory.AbstractPage

class ListPage(
    title:String,
    author:String
): AbstractPage(title, author) {
    override fun makeHTML(): String {
        var buffer = ""
        buffer += title
        val it: MutableIterator<AbstractItem> = content.iterator()

        while (it.hasNext()) {
            val item: AbstractItem = it.next()
            buffer += " ${item.makeHTML()} "
        }

        buffer += author

        return buffer
    }

}