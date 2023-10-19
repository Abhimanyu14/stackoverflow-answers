package com.makeappssimple.abhimanyu.stackoverflowanswers.android.customview

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.math.min

/**
 * Sun
 * https://stackoverflow.com/questions/73581518/draw-circle-at-the-end-of-arc-android-canvas
 *
 * Gauge
 * https://stackoverflow.com/questions/74010297/create-a-needle-gaugeview-from-ios-swift-to-androidkotlin
 *
 * Custom range slider
 * https://stackoverflow.com/questions/76039011/android-custom-rangeslider-view
 *
 * Custom Seekbar
 * https://stackoverflow.com/questions/76967237/custom-view-seekbar-in-android
 */
class CustomViewActivity : AppCompatActivity() {
    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
        // requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        // networkCall()
        // setUpLinearProgressView()
    }

//    private fun setUpLinearProgressView() {
//        val restartButton = findViewById<Button>(R.id.restart_btn)
//        val linearProgressView = findViewById<LinearProgressView>(R.id.linear_progress_view)
//        linearProgressView.progressHeight = 30
//        restartButton.setOnClickListener {
//            linearProgressView.progress = 0F
//            job?.cancel()
//            job = lifecycleScope.launch(Dispatchers.Main) {
//                while (linearProgressView.progress < 1F) {
//                    linearProgressView.progress = min(1F, linearProgressView.progress + 0.01F)
//                    Log.e("Abhi", "${linearProgressView.progress}")
//                    delay(20)
//                }
//            }
//        }
//    }

    private fun networkCall() {
        val tv = findViewById<TextView>(R.id.text)
        // Call the network request method within a coroutine
        lifecycleScope.launch(Dispatchers.Main) {
            val result = makeNetworkRequest("https://catfact.ninja/breeds")
            if (result != null) {
                tv.text = result
            } else {
                tv.text = "Not Found"
            }
        }
    }
}

suspend fun makeNetworkRequest(urlString: String): String? = withContext(Dispatchers.IO) {
    try {
        val url = URL(urlString)
        val connection = url.openConnection() as HttpURLConnection
        connection.apply {
            requestMethod = "GET"
            connectTimeout = 5000
            readTimeout = 5000
            connect()
        }
        val responseCode = connection.responseCode
        if (responseCode == HttpURLConnection.HTTP_OK) {
            val inputStream: InputStream = connection.inputStream
            val reader = BufferedReader(InputStreamReader(inputStream))
            val response = StringBuilder()
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                response.append(line)
            }
            reader.close()
            response.toString()
        } else {
            // Handle the error, e.g., by throwing an exception or returning an error message.
            null
        }
    } catch (e: IOException) {
        // Handle exceptions, e.g., network issues or URL problems.
        null
    }
}

