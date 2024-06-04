package com.example.estudosretrofit.services

import com.example.estudosretrofit.model.Endereco
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.PATCH
import retrofit2.http.Path

interface AdressApi {


    @GET("ws/{cep}/json/")
    suspend fun recoverAdress(
        @Path("cep") cep: String
    ) : Response<Endereco>
}