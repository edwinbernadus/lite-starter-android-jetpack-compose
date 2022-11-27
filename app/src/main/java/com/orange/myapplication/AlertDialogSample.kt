package com.orange.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.orange.myapplication.model.Album
import com.orange.myapplication.service.simpleNavService

@Composable
fun AlertDialogSample(album : Album) {
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(false) }

            Button(onClick = {
                openDialog.value = true
            }) {
                Text("Click me")
            }

            if (openDialog.value) {

                AlertDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    },
                    title = {
                        Text(text = "${album.id} - ${album.title}")
                    },
                    text = {
//                        Text("Here is a text ")
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                openDialog.value = false
                                simpleNavService.goTo("/third_page")
                            }) {
                            Text("Go To Next Page")
                        }
                    },
                    dismissButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("This is the dismiss Button")
                        }
                    }
                )
            }
        }
    }
}