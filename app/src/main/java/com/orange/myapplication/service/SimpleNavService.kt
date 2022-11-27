package com.orange.myapplication.service

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.*



//var prevRoute = ""
val routes : LinkedList<String> = LinkedList<String>()
var currentRoute by mutableStateOf("/")

class SimpleNavService {

    fun goBack(): Boolean {
        routes.removeAt(routes.size -1)

//        var last = routes.last()
//        routes.remove(last)

        if (routes.size > 0){
            var last2 = routes.last()
            currentRoute = last2
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