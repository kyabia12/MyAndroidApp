package com.greengoat3.android.mydesignpatternapp.abstractFactory.listfactory

import com.greengoat3.android.mydesignpatternapp.abstractFactory.factory.AbstractFactory
import com.greengoat3.android.mydesignpatternapp.abstractFactory.factory.AbstractLink
import com.greengoat3.android.mydesignpatternapp.abstractFactory.factory.AbstractPage
import com.greengoat3.android.mydesignpatternapp.abstractFactory.factory.AbstractTray

class ListFactory: AbstractFactory() {
    override fun createLink(caption: String, url: String):AbstractLink {
        return ListLink(caption, url)
    }

    override fun createTray(caption: String): AbstractTray {
        return ListTray(caption)
    }

    override fun createPage(title: String, author: String): AbstractPage {
        return ListPage(title, author)
    }
}