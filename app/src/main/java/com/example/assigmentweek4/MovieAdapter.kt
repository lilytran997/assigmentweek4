package com.example.assigmentweek4

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.assigmentweek4.model.movie
import kotlinx.android.synthetic.main.movie_row.view.*

class MovieAdapter(var items: ArrayList<movie.Results>, val context: Context) : RecyclerView.Adapter<MovieViewHolder>()  {
    lateinit var mListener: MovieItemCLickListener
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(movieViewHolder: MovieViewHolder, position: Int) {
        movieViewHolder.name.text ="#$position ${items[position].title}"
        movieViewHolder.description.text = items[position].overview
        Glide.with(context)
            .load(	"https://image.tmdb.org/t/p/w500/"+ items[position].poster_path)
            .centerCrop()
            .into(movieViewHolder.movie)

        movieViewHolder.itemView.setOnClickListener {
            mListener.onItemCLicked(position)
        }

    }
    fun setListenner(listener: MovieItemCLickListener){
        this.mListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_row,parent,false))
    }

}

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var movie = view.movie
    var name = view.name
    var description = view.des

}