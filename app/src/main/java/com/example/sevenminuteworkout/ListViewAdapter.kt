package com.example.sevenminuteworkout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sevenminuteworkout.databinding.RecyclerViewItemBinding

class ListViewAdapter(val taskList: List<Task>): RecyclerView.Adapter<ListViewAdapter.ListViewHolder>() {
    inner class ListViewHolder(val itemBinding: RecyclerViewItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(task: Task){
           itemBinding.tvTitle.text = task.title
           itemBinding.tvTimer.text = task.timestampt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
       return ListViewHolder(RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val task = taskList[position]
        holder.bindItem(task)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

}