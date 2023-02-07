package com.akinozcitak.retrofitkotlin.service

import com.akinozcitak.retrofitkotlin.model.ColorBookModel
import retrofit2.Call
import retrofit2.http.GET

interface ColorBookAPI {

    //GET, POST, UPDATE, DELETE

    //https://raw.githubusercontent.com/
    // atilsamancioglu/K21-JSONDataSet/master/crypto.json

    //https://api.nomics.com/v1/
    // prices?key=2187154b76945f2373394aa34f7dc98a

    @GET("jennyknuth/e2d9ee930303d5a5fe8862c6e31819c5/raw/e4ec571a9b49ddc5c1789a4e7f3c67ec5271398e/colors.json")
    fun getData(): Call<List<ColorBookModel>>

    //fun getData(): Call<List<CryptoModel>>


}