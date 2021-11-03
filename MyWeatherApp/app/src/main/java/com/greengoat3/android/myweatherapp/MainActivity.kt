package com.greengoat3.android.myweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.greengoat3.android.myweatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}