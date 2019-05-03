package com.example.assigmentweek4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.assigmentweek4.model.movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var movies: ArrayList<movie.Results> = ArrayList()
    val Movies = movie()
    lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.title = "List Movie"

        // init clone movie data
        addMovie()
        // setup layout manager and adapter
        list_movie.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter(movies, this)
        list_movie.adapter = movieAdapter

        //set onclick item movie
        movieAdapter.setListenner(movieItemCLickListener)

    }
    private val movieItemCLickListener = object : MovieItemCLickListener {

        override fun onItemCLicked(position: Int) {

            val intent = Intent(this@MainActivity,DetailsMovieActivity::class.java)
            intent.putExtra(MOVIE_TITLE_KEY,movies[position].title)
            intent.putExtra(MOVIE_POSTER_KEY,movies[position].poster_path)
            intent.putExtra(MOVIE_DES_KEY,movies[position].overview)
            intent.putExtra(MOVIE_VIDEO_KEY,movies[position].video)
            intent.putExtra(MOVIE_BACKDROP_KEY,movies[position].backdrop_path)
            intent.putExtra(MOVIE_VOTE_KEY,movies[position].vote_average)
            intent.putExtra(MOVIE_DATE_KEY,movies[position].release_date)
            startActivity(intent)

        }
    }

    private fun addMovie() {
        for(i in Movies.getMovieModel().results){
            movies.add(i)
            Log.i("film array", movies.toString())
        }
    }
}
