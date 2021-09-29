package com.greengoat3.android.mydesignpatternapp.factory.factory

abstract class Factory {
    fun create(serialNumber: String) : Product {
        val product: Product = createProduct(serialNumber)
        registerProduct(product)

        return product
    }

    protected abstract fun createProduct(serialNumber: String) : Product

    protected abstract fun registerProduct(product: Product)
}