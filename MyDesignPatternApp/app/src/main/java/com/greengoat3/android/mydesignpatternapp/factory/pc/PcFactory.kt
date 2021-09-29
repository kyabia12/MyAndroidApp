package com.greengoat3.android.mydesignpatternapp.factory.pc

import com.greengoat3.android.mydesignpatternapp.factory.factory.Factory
import com.greengoat3.android.mydesignpatternapp.factory.factory.Product

class PcFactory: Factory() {
    private val _serialNumberList = mutableListOf("")

    override fun createProduct(serialNumber: String): Product {
        return Pc(serialNumber)
    }

    override fun registerProduct(product: Product) {
        _serialNumberList.add((product as Pc).getSerialNumber())
    }

    fun getSerialNumberList(): List<String> {
        return _serialNumberList
    }

}