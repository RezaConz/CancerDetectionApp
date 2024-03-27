package com.dicoding.asclepius.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.asclepius.data.local.entity.History
import com.dicoding.asclepius.databinding.ItemSaveLayoutBinding

class HistoryAdapter: ListAdapter<History, HistoryAdapter.MyViewHolder>(DIFF_CALLBACK) {

    var onClick: ((History) -> Unit)? = null

    class MyViewHolder (private val binding: ItemSaveLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : History,onClick: ((History) -> Unit)?){

            binding.tvPrediction.text = item.prediction
            binding.tvScore.text = item.score
            binding.ivImage.setImageURI(item.image?.toUri())
            binding.buttonDelete.setOnClickListener {
                onClick?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemSaveLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listUser = getItem(position)
        holder.bind(listUser,onClick)
    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<History>(){
            override fun areItemsTheSame(oldItem: History, newItem: History): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: History, newItem: History): Boolean {
                return oldItem == newItem
            }
        }
    }
}