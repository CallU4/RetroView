package com.example.retroview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retroview.databinding.ActivityMainBinding
import com.example.retroview.network.CatsApi
import com.example.retroview.network.models.Fact
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var bind : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val service =  Retrofit.Builder()
            .baseUrl("https://catfact.ninja")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(CatsApi::class.java)

        CoroutineScope(Dispatchers.IO).launch{
            bind.textView
        }
    }
}