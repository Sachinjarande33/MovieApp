package com.example.finalmoveilist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieListAdapter(private var mList: List<Search>) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {


   // var onClick : ((String)->Unit)? = null
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.innsight_movie_list, parent, false)
        context = parent.context

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        Glide.with(holder.imageView).load(ItemsViewModel.Poster).into(holder.imageView)
        holder.textViewTitle.text = ItemsViewModel.Title
       holder.textViewDate.text = ItemsViewModel.Year
        holder.itemView.rootView.setOnClickListener{
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra("id",ItemsViewModel.imdbID)
            context.startActivity(intent)
        }


    }


    override fun getItemCount(): Int {
        return mList.size
    }

    fun setMovies(mList: List<Search>) {
        this.mList = mList
        notifyDataSetChanged()
    }

  /*  fun onMovieClick(listener:(String) -> Unit) {
        onClick = listener
    }*/

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imagePoster)
        val textViewTitle: TextView = itemView.findViewById(R.id.titleMovie)
        val textViewDate: TextView = itemView.findViewById(R.id.textReleaseYear)



    }
}
