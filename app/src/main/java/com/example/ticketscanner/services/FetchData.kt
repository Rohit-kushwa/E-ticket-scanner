package com.example.ticketscanner.services

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

suspend fun fetchData(onResult: (Result<String>) -> Unit) {
    val url = URL("https://eticket-uat.ckcloud.in/api/Get/username=verify/password=123")
    val connection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "GET"

    val responseCode = connection.responseCode
    if (responseCode == HttpURLConnection.HTTP_OK) {
        val reader = BufferedReader(InputStreamReader(connection.inputStream))
        val response = StringBuilder()

        var line: String? = reader.readLine()
        while (line != null) {
            response.append(line)
            line = reader.readLine()
        }

        reader.close()
        connection.disconnect()
        Log.d("myTag", "fetchData: " + response.toString())
        onResult(Result.success(response.toString()))
    } else {
        connection.disconnect()
        onResult(Result.failure(Exception("Failed to fetch data")))
        Log.d("errorTag", "fetchData: " )

    }
}