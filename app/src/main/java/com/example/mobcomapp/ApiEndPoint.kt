package com.example.mobcomapp

import android.telecom.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET("data.php")
    fun data() : Call<CakeModel>
}