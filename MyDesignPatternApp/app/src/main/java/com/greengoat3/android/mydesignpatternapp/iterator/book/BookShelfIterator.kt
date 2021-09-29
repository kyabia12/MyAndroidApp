package com.greengoat3.android.mydesignpatternapp.iterator.book

import com.greengoat3.android.mydesignpatternapp.iterator.iterator.Iterator

class BookShelfIterator(
    private val bookShelf: BookShelf
) : Iterator {
    private var index = 0

    override fun hasNext(): Boolean {
        return index < bookShelf.getLength()
    }

    override fun next(): Any {
        val book = bookShelf.getBookAt(index)
        index++
        return book
    }
}