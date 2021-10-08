package com.greengoat3.android.mydesignpatternapp.builder

class Director(
    private val builder: Builder
) {
     fun construct() {
        builder.makeTitle("Greeting")
        builder.makeString("朝から昼にかけて")
        builder.makeItems(arrayListOf("おはようございます", "こんにちは"))
        builder.makeString("夜に")
        builder.makeItems(arrayListOf("こんばんは", "おやすみなさい", "さようなら"))
        builder.close()
    }
}