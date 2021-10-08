package com.greengoat3.android.mydesignpatternapp.abstractFactory.factory

abstract class AbstractLink(
    caption: String,
    protected val url: String
): AbstractItem(caption)