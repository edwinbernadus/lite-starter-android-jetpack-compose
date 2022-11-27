package com.orange.myapplication

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.orange.myapplication.model.Album

var totalData by mutableStateOf(0)
var loadingStatus by mutableStateOf("no_data")
var albumsRepo = arrayOf<Album>()


@Composable
fun ListTableScreen() {
    Text(
        text = loadingStatus,
        fontSize = 30.sp,
        color = Color.White
    )

//    hint_show_webservice_result_on_list
    LazyColumn {
        items(totalData) { index ->

            var item = albumsRepo[index]
            Text(text = "${item.id} - ${item.title}")
//            hint_button_on_list
//            hint_show_detail_item_on_alert
            AlertDialogSample(item)
        }
    }
}