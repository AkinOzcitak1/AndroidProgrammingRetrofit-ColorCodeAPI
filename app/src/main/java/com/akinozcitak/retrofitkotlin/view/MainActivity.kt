package com.akinozcitak.retrofitkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akinozcitak.retrofitkotlin.adapter.RecyclerViewAdapter
import com.akinozcitak.retrofitkotlin.databinding.ActivityMainBinding
import com.akinozcitak.retrofitkotlin.model.ColorBookModel
import com.akinozcitak.retrofitkotlin.service.ColorBookAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.Listener {
    private val BASE_URL = "https://gist.githubusercontent.com/"
    private var colorBookModels: ArrayList<ColorBookModel>? = null
    private var recyclerViewAdapter : RecyclerViewAdapter? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        loadData()

    }
    private fun loadData() {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(ColorBookAPI::class.java)
        val call = service.getData()
        call.enqueue(object : Callback<List<ColorBookModel>> {
            override fun onResponse(
                call: Call<List<ColorBookModel>>,
                response: Response<List<ColorBookModel>>
            ) {
                if(response.isSuccessful) {
                    response.body()?.let {
                        colorBookModels = ArrayList(it)
                        recyclerViewAdapter = RecyclerViewAdapter(colorBookModels!!, this@MainActivity)
                        binding.recyclerView.adapter = recyclerViewAdapter


                        /*for(colorBookModel: ColorBookModel in colorBookModels!!) {
                            println(colorBookModel.hex)
                            println(colorBookModel.name)

                        }*/
                    }
                }
            }

            override fun onFailure(call: Call<List<ColorBookModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

    override fun onItemClick(colorBookModel: ColorBookModel) {
         Toast.makeText(this, "Clicked: ${colorBookModel.name}", Toast.LENGTH_SHORT).show()
    }
}