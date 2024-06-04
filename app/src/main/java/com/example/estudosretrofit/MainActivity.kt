package com.example.estudosretrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudosretrofit.databinding.ActivityMainBinding
import com.example.estudosretrofit.model.Endereco
import com.example.estudosretrofit.services.AdressApi
import com.example.estudosretrofit.services.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

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

        var retorno: Response<Endereco>? = null
        var cep = "71691019"

        try {
            val adressApi = retrofit.create(AdressApi::class.java)
            retorno = adressApi.recoverAdress(cep)
        }catch (e: Exception){
            e.printStackTrace()
            Log.i("info_endereço:", "erro ao recuperar")
        }

        if (retorno != null){
            if (retorno.isSuccessful){

                val endereco = retorno.body()
                val rua = endereco?.logradouro
                val cidade = endereco?.localidade

                Log.i("info_endereço:", "endereco: $rua , $cidade")

            }

        }

    }

}