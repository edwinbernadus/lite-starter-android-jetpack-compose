package com.orange.myapplication

import android.content.Context
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.orange.myapplication.service.simpleNavService

@Composable
fun FirstPageScreen(context: Context) {
    Text(
        text = "main",
        fontSize = 30.sp,
        color = Color.White
    )
//    hint_create_button
    Button(
        onClick = {
//            hint_open_new_page
            simpleNavService.goTo("/list_table")
            callJs(context)
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
    )

    {
        Text(text = "Go To List Table", color = Color.White)
    }
}