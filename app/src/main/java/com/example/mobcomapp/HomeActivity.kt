package com.example.mobcomapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.mobcomapp.adapter.CakesAdapter
import com.example.mobcomapp.entities.menus
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class HomeActivity : AppCompatActivity() {
    var cakes = ArrayList<menus>()
    var cakesAdapter = CakesAdapter()

    private val api by menus { ApiRetrofit().endPoint }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        api.data().enqueue(object : Callback<CakeModel> {
            override fun onFailure(call: Call<CakeModel>, t: Throwable) {
                Log.e("HomeActivity", t.toString())
            }

            override fun onResponse(call: Call<CakeModel>, response: Response<CakeModel>) {
                if (response.isSuccessful) {
                    Log.e("HomeActivity", response.toString())
                }
            }
        })

        // Inisialisasi data contoh
        cakes.add(menus(1, "Choco Brownies", R.drawable.cake2))
        cakes.add(menus(2, "White Brownies", R.drawable.cake3))

        // Temukan RecyclerView dengan ID cake_id
        val recyclerView: RecyclerView = findViewById(R.id.cake_id)

        // Atur LayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Set data ke adapter
        cakesAdapter.setData(cakes)

        // Set adapter ke RecyclerView
        recyclerView.adapter = cakesAdapter
    }

}