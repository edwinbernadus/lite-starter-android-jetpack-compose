package com.orange.myapplication.service

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.*

val routes : LinkedList<String> = LinkedList<String>()
var currentRoute by mutableStateOf("/")

class SimpleNavService {

    fun goBack(): Boolean {
        routes.removeAt(routes.size -1)

        if (routes.size > 0){
            var lastItem = routes.last()
            currentRoute = lastItem
        }

        if (routes.size == 0){
            return true
        }

        return false
    }

    fun goTo(route : String){
        currentRoute = route
        routes.add(route)
    }
}


var simpleNavService = SimpleNavService()