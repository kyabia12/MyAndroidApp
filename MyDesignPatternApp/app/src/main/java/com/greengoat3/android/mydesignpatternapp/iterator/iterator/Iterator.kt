package com.greengoat3.android.mydesignpatternapp.iterator.iterator

interface Iterator {
    abstract fun hasNext(): Boolean
    abstract fun next(): Any
}