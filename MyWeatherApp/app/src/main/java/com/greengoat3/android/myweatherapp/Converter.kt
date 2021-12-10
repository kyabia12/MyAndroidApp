package com.greengoat3.android.myweatherapp

import androidx.databinding.InverseMethod

object Converter {
    @InverseMethod("inverseToDouble")
    @JvmStatic fun inverseToString(
        value: Double
    ): String {
        return value.toString()
    }

    @JvmStatic fun inverseToDouble(
        value: String?
    ): Double {
        return kotlin.runCatching { value?.toDouble() }
            .getOrNull() ?: 0.0
    }
}