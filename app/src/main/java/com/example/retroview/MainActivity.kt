package com.example.retroview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.retroview.databinding.ActivityMainBinding
import com.example.retroview.network.CatsApi
import com.example.retroview.network.models.Fact
import com.google.gson.GsonBuilder
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding

    private val defAnswer = "Undefined"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        var sharedPref = getSharedPreferences("pref", MODE_PRIVATE)
        var editor = sharedPref.edit()


        bind.saveButton.setOnClickListener{
            var name = bind.nameBox.text.toString()
            var isChecked = bind.checkBox.isChecked

            editor.apply{
                putString("name", name)
                putBoolean("isAged", isChecked)
                apply()
            }
        }

        bind.getButton.setOnClickListener{
            val name = sharedPref.getString("name", defAnswer)
            val isChecked = sharedPref.getBoolean("isAged", false)
            bind.nameView.text = name
            bind.checkBox.isChecked = isChecked
        }
}


}
