package com.orange.myapplication

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.orange.myapplication.model.Album



fun callJs(context : Context) {
//    hint_loading_webservice
    val queue = Volley.newRequestQueue(context)
    var url = "https://jsonplaceholder.typicode.com/albums"

    val stringRequest = StringRequest(
        Request.Method.GET, url,
        { response ->

            var json = response
            val gson = Gson()

            val albums: Array<Album> = gson.fromJson(json, Array<Album>::class.java)

            albumsRepo = albums
            totalData = albums.size
            loadingStatus = "end"
        }) {
    }

//    hint_show_loading_indicator
    loadingStatus = "start"
    queue.add(stringRequest)
}