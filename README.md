# starter-template-android-jetpack-compose

## Getting Started
**read this first**  
https://github.com/edwinbernadus/starter-template-frontend-framework


## Snippet List
- hint_create_button
````kotlin
//  hint_create_button
Button(
    onClick = {
        simpleNavService.goTo("/list_table")
        callJs(context)
    },
    colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
)
````
- hint_open_new_page
````kotlin
//  hint_open_new_page
simpleNavService.goTo("/list_table")
````
- hint_loading_webservice
````kotlin
//  hint_loading_webservice
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
loadingStatus = "start"
queue.add(stringRequest)
````
- hint_show_loading_indicator
````kotlin
//  hint_show_loading_indicator
loadingStatus = "start"
````
- hint_show_webservice_result_on_list
````kotlin
//  hint_show_webservice_result_on_list
LazyColumn {
    items(totalData) { index ->

        var item = albumsRepo[index]
        Text(text = "${item.id} - ${item.title}")
        AlertDialogSample(item)
    }
}
````
- hint_button_on_list
````kotlin
//  hint_button_on_list
AlertDialogSample(item)
````
- hint_show_detail_item_on_alert
````kotlin
//  hint_show_detail_item_on_alert
AlertDialogSample(item)
````