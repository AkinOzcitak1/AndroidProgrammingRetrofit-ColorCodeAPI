package com.akinozcitak.retrofitkotlin.service

import android.database.Observable
import com.akinozcitak.retrofitkotlin.model.ColorBookModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ColorBookAPI {


    @GET("jennyknuth/e2d9ee930303d5a5fe8862c6e31819c5/raw/e4ec571a9b49ddc5c1789a4e7f3c67ec5271398e/colors.json")
    suspend fun getData(): Response<List<ColorBookModel>>

    //fun getData(): Observable<List<ColorBookModel>>


}