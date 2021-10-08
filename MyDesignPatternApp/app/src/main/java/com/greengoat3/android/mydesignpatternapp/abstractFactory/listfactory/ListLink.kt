package com.greengoat3.android.mydesignpatternapp.abstractFactory.listfactory

import com.greengoat3.android.mydesignpatternapp.abstractFactory.factory.AbstractLink

class ListLink(
    caption: String,
    url: String
): AbstractLink(caption, url) {
    override fun makeHTML(): String {
        return "$url $caption"
    }
}