package com.greengoat3.android.mydesignpatternapp.abstractFactory.factory

abstract class OsFileSystem {
    abstract fun getFileSeparator() : String
    abstract fun getRootPath() : String
    abstract fun saveFile(fileName: String)
}