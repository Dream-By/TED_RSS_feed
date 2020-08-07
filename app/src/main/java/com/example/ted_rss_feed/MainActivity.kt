package com.example.ted_rss_feed

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val url = "https://raw.githubusercontent.com/rolling-scopes-school/rs.android.task.6/master/data/data.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getResponse(url)
    }


    fun getResponse(url:String){

        val request = ServiceBuilder.buildService(ApiInterface::class.java)
        val call = request.getItems(url)

        call.enqueue(object : Callback<GitResponse> {
            override fun onFailure(call: Call<GitResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_LONG).show()
            }
            override fun onResponse(call: Call<GitResponse>, response: Response<GitResponse>) {
                if (response.isSuccessful) {
                    recyclerview.apply {
                        progress_bar.visibility = View.GONE
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = MyAdapter(response.body()?.channel?.item ?: listOf())
                        recyclerview.adapter = adapter
                        (adapter as MyAdapter).notifyDataSetChanged()
                    }
                }
            }
        })

    }
}
