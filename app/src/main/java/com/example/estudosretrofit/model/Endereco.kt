package com.example.estudosretrofit.model

import com.google.gson.annotations.SerializedName

data class Endereco(

    @SerializedName("bairro")
    val nomeBairro: String,
    val cep: String,
    val complemento: String,
    val ddd: String,
    val gia: String,
    val ibge: String,
    val localidade: String,
    val logradouro: String,
    val siafi: String,
    val uf: String
)