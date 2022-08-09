package com.rahul.notificationstest.feature.search.ui.activities

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.rahul.notificationstest.R
import com.rahul.notificationstest.feature.search.ui.fragments.SearchFragment

class SearchActivity : AppCompatActivity() {
    lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        frameLayout = findViewById(R.id.container)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, SearchFragment())
            .commit()

    }
}