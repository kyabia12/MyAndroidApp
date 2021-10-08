package com.greengoat3.android.mydesignpatternapp.abstractFactory.factory

abstract class AbstractTray(
    caption: String
): AbstractItem(caption) {
    protected val tray = mutableListOf<AbstractItem>()
    fun add(item:AbstractItem) {
        tray.add(item)
    }
}