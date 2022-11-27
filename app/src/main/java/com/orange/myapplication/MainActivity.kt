package com.orange.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orange.myapplication.model.Album
import com.orange.myapplication.service.currentRoute
import com.orange.myapplication.service.simpleNavService
import com.orange.myapplication.ui.theme.MyApplicationTheme


var totalData by mutableStateOf(0)
var loadingStatus by mutableStateOf("no_data")
var albumsRepo = arrayOf<Album>()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        simpleNavService.goTo("/")
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    getTitleBar()
                                },
                                navigationIcon = {
                                    getBackIcon()
                                },
                                backgroundColor = MaterialTheme.colors.primary,
                                contentColor = Color.White,
                                elevation = 10.dp
                            )
                        }, content = {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color(0xff8d6e63)),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                getContent()
                            }
                        }
                    )
                }
            }
        }
    }

    @Composable
    private fun getTitleBar() {
        Text(text = "Route: " + currentRoute)
    }

    @Composable
    private fun getBackIcon() {
        if (currentRoute != "/") {
            IconButton(onClick = {
                simpleNavService.goBack()
//                if (currentRoute != "/") {
//                    simpleNavService.goTo("/")
//                }

            }) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        }
    }

    override fun onBackPressed() {
        var isFinish = simpleNavService.goBack()
        if (isFinish){
            finishAffinity();
            finish();
        }
    }

    @Composable
    private fun getContent() {
        if (currentRoute == "/") {
            FirstPageScreen(applicationContext)
        } else if (currentRoute == "/list_table") {
            ListTableScreen()
        } else if (currentRoute == "/third_page") {
            ThirdPageScreen()
        }else {
            defaultNoRoute()
        }
    }

    @Composable
    private fun defaultNoRoute() {
        Text(
            text = "no_route_info",
            fontSize = 30.sp,
            color = Color.White
        )
    }
}






