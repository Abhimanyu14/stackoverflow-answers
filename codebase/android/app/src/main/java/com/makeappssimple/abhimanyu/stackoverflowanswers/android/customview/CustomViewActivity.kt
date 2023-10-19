package com.makeappssimple.abhimanyu.stackoverflowanswers.android.customview

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class CustomViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        // networkCall()
    }

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

class Frag : Fragment(R.layout.activity_custom_view) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }
}
