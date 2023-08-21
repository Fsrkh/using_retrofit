package com.example.usingretrofit.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.usingretrofit.MovieDetailesActivity
import com.example.usingretrofit.R
import com.example.usingretrofit.databinding.ItemMoviesBinding
import com.example.usingretrofit.response.MoviesListResponse
import com.example.usingretrofit.utils.Constants.POSTER_BASE_URL

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder> () {
    private lateinit var binding: ItemMoviesBinding
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: MoviesListResponse.Result) {
            binding.apply {
                tvMovieName.text = item.title
                tvMovieDateRelease.text = item.releaseDate
                tvRate.text = item.voteAverage.toString()
                val moviePosterURL = POSTER_BASE_URL + item?.posterPath
                ImgMovie.load(moviePosterURL) {
                    crossfade(true)
                    placeholder(R.drawable.poster_placeholder)
                    scale(Scale.FILL)
                }
                tvLang.text = item.originalLanguage
                root.setOnClickListener {
                    val intent = Intent(context, MovieDetailesActivity::class.java)
                    intent.putExtra("id", item?.id)
                    context.startActivity(intent)
                }
            }

        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<MoviesListResponse.Result>() {







        override fun areItemsTheSame(
            oldItem: MoviesListResponse.Result,
            newItem: MoviesListResponse.Result
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MoviesListResponse.Result,
            newItem: MoviesListResponse.Result
        ): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)
}