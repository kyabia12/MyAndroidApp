package com.greengoat3.android.mydesignpatternapp.iterator.book

import com.greengoat3.android.mydesignpatternapp.iterator.iterator.Aggregate
import com.greengoat3.android.mydesignpatternapp.iterator.iterator.Iterator
import java.lang.reflect.Array

class BookShelf() : Aggregate {
    private val books: MutableList<Book> = mutableListOf()
    private var last = 0

    fun getBookAt(index: Int): Book {
        return books[index]
    }

    fun appendBook(book: Book) {
        books.add(book)
        last++
    }

    fun getLength(): Int {
        return last
    }

    override fun iterator(): Iterator {
        return BookShelfIterator(this)
    }
}