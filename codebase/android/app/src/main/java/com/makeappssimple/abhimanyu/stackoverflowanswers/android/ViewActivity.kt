package com.makeappssimple.abhimanyu.stackoverflowanswers.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        // findViewById<MyComposeView>(R.id.my_view).titleValue = "From Activity"
    }
}
