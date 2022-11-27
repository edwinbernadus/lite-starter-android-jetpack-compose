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
fun ThirdPageScreen() {
    Text(
        text = "third",
        fontSize = 30.sp,
        color = Color.White
    )
//    hint_create_button
    Button(
        onClick = {
            simpleNavService.goTo("/list_table")
//            simpleNavService.goBack()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
    )

    {
        Text(text = "Go To List Table 2", color = Color.White)
    }
}