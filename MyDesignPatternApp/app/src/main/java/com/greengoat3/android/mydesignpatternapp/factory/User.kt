package com.greengoat3.android.mydesignpatternapp.factory

class User(val name: String) {
    companion object {
        fun from(name: String): User {
            return User(name)
        }
    }
}