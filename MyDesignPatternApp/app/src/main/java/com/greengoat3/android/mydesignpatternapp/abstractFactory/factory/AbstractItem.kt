package com.greengoat3.android.mydesignpatternapp.abstractFactory.factory

abstract class AbstractItem(
    protected val caption: String
) {
    abstract fun makeHTML(): String
}