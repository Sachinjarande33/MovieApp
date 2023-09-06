/*
package com.example.finalmoveilist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalmoveilist.Models.MovieList
import com.example.finalmoveilist.Models.Result
import com.example.finalmoveilist.Models.ResultX

class CustomAdapter(private var mList: List<ResultX>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        //holder.imageView.setImageResource(ItemsViewModel.path)

        // sets the text to the textview from our itemHolder class
       // Glide.with(context).load(mList.get(position)).into(holder.imageView)
        holder.textViewTitle.text = ItemsViewModel.title
        holder.textViewDate.text = ItemsViewModel.release_date

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    fun setMovies(mList: List<ResultX>) {
        this.mList = mList
        notifyDataSetChanged()
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        //val imageView: ImageView = itemView.findViewById(R.id.imageViewMoviePoster)
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewMovieTitle)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewReleaseDate)


    }
}
*/
