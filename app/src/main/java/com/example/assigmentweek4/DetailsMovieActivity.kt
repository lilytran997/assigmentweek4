package com.example.assigmentweek4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class DetailsMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
        //toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.title = "Details Movie"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
