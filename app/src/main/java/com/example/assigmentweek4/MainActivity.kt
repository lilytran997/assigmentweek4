package com.example.assigmentweek4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.assigmentweek4.model.movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var movie: ArrayList<movie> = ArrayList()
    lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.title = "List Movie"

        // init clone movie data
        addMovie()
        // setup layout manager and recyclerview
        list_movie.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager

        movieAdapter = MovieAdapter(movie, this)
        //set onclick item movie
        movieAdapter.setListener(movieItemCLickListener)

    }
    private val movieItemCLickListener = object : MovieItemCLickListener {

        override fun onItemCLicked(position: Int) {

            val intent = Intent(this@MainActivity,DetailsMovieActivity::class.java)
            //intent...
            startActivity(intent)

        }
    }

    private fun addMovie() {
        //...
    }
}
