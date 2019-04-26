package com.example.assigmentweek4

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.assigmentweek4.model.movie
import kotlinx.android.synthetic.main.movie_row.view.*

class MovieAdapter(var items: ArrayList<movie>, val context: Context) : RecyclerView.Adapter<MovieViewHolder>()  {
    lateinit var mListener: MovieItemCLickListener
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(movieViewHolder: MovieViewHolder, p1: Int) {

        //...
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_row,parent,false))
    }

    fun setListener(listener: MovieItemCLickListener) {
        this.mListener = listener
    }

    fun setData(items: ArrayList<movie>){
        this.items = items
        notifyDataSetChanged()
    }
}

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var movie = view.movie
    var name = view.name
    var description = view.des

}