package com.cibertec.movieapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.movieapplication.R
import com.squareup.picasso.Picasso

class ResultAdapter(private val listaPeliculas: List<com.cibertec.movieapplication.entities.Result>): RecyclerView.Adapter<ResultAdapter.ResultHolder>() {

    inner class ResultHolder(val v: View): RecyclerView.ViewHolder(v){
        var tituloMovie: TextView
        var sinopsisMovie: TextView
        var fechaMovie: TextView
        var puntuacionMovie: TextView
        var posterMovie: ImageView
        init {
            tituloMovie = v.findViewById(R.id.objNameMovie)
            sinopsisMovie = v.findViewById(R.id.objSynopsisMovie)
            fechaMovie = v.findViewById(R.id.objReleaseDateMovie)
            puntuacionMovie = v.findViewById(R.id.objRateMovie)
            posterMovie = v.findViewById(R.id.objImageMovie)
        }

        fun bindData(data: com.cibertec.movieapplication.entities.Result) = with(v){
            tituloMovie.text = data.title
            sinopsisMovie.text = data.overview
            fechaMovie.text = data.release_date
            puntuacionMovie.text = "Calificacion: ${data.vote_average}"

            Picasso.get().load("https://image.tmdb.org/t/p/original/${data.poster_path}").into(posterMovie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultAdapter.ResultHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_ver_movie,parent,false)
        return ResultHolder(itemView)
    }

    override fun onBindViewHolder(holder: ResultAdapter.ResultHolder, position: Int) {
        listaPeliculas.let {
            it.get(position).let { it1 -> holder.bindData(it1) }
        }
    }

    override fun getItemCount(): Int {
        return listaPeliculas.count()
    }

}