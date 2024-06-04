package com.example.estudosretrofit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudosretrofit.databinding.ActivityMainBinding
import com.example.estudosretrofit.services.AdressApi
import com.example.estudosretrofit.services.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val retrofit by lazy {
        RetrofitHelper.retrofit
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnIniciar.setOnClickListener(){

            CoroutineScope(Dispatchers.IO).launch {
                recoverAdress()
            }

        }

    }

    private suspend fun recoverAdress(){

        val adressApi = retrofit.create(AdressApi::class.java)
        adressApi.recoverAdress()

    }



}