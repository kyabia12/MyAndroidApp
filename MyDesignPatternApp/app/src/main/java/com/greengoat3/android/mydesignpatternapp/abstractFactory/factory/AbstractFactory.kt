package com.greengoat3.android.mydesignpatternapp.abstractFactory.factory

import android.util.Log
import java.lang.Exception

abstract class AbstractFactory {
    companion object {
        fun getFactory(classname: String): AbstractFactory? {
            var factory:AbstractFactory? = null

            try {
                factory = Class.forName(classname).newInstance() as AbstractFactory
            } catch (e: Exception) {
                Log.e("AbstractFactory", e.toString())
            }

            return factory
        }
    }

    abstract fun createLink(caption: String, url: String): AbstractLink
    abstract fun createTray(caption: String): AbstractTray
    abstract fun createPage(title: String, author:String): AbstractPage
}