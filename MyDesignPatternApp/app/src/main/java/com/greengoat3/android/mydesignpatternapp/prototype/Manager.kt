package com.greengoat3.android.mydesignpatternapp.prototype

class Manager {
    private var showcase =  mutableMapOf<String, Product>()

    fun register(name: String, proto: Product) {
        showcase.put(name, proto)
    }
    fun create(protoname: String): Product {
        val p = showcase.get(protoname) as Product
        return p.createClone()
    }
}