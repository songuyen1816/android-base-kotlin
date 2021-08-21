package com.bsp.basekotlin.ui.filmlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bsp.basekotlin.data.model.FilmItem
import com.bsp.basekotlin.databinding.ListItemFilmBinding

class FilmListAdapter :
    ListAdapter<FilmItem, FilmListAdapter.FilmListItemViewHolder>(FilmItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FilmListItemViewHolder(ListItemFilmBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: FilmListItemViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    inner class FilmListItemViewHolder(private val binding: ListItemFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(film: FilmItem) {
            binding.filmData = film
        }
    }

}

class FilmItemDiffCallback : DiffUtil.ItemCallback<FilmItem>() {
    override fun areItemsTheSame(oldItem: FilmItem, newItem: FilmItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FilmItem, newItem: FilmItem): Boolean {
        return oldItem == newItem
    }
}