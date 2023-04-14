package com.catsapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.catsapi.databinding.CardCatBreedsBinding
import com.catsapi.ui.models.CatbreedBinding

class CatbreedsAdapter : RecyclerView.Adapter<CatbreedsAdapter.ViewHolder>() {

    private val items: MutableList<CatbreedBinding> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CardCatBreedsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    fun setData(newItems: List<CatbreedBinding>) {
        this.items.clear()
        this.items.addAll(newItems)
        notifyItemChanged(0, items.lastIndex)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(
        private val binding: CardCatBreedsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(catBreed: CatbreedBinding) {
            binding.catBreed = catBreed
        }
    }

}