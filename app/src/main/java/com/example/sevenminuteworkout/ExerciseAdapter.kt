package com.example.sevenminuteworkout

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.sevenminuteworkout.databinding.ItemExerciseStatusBinding

class ExerciseAdapter(var list: ArrayList<ExerciseModel>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseHolder>() {
    inner class ExerciseHolder(itemBinding: ItemExerciseStatusBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        val tvItem = itemBinding.tvItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseHolder {
        return ExerciseHolder(
            ItemExerciseStatusBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ExerciseHolder, position: Int) {
        val modal = list[position]
        holder.tvItem.text = modal.getId().toString()

        when {
            modal.getIsSelected() -> {
                holder.tvItem.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.item_circular_color_thin_accent_background
                )
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
            modal.getIsCompleted() -> {
                holder.tvItem.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.circlar_color_accent_background
                )
                holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))
            }
            else -> {
                holder.tvItem.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.item_circular_color_gray_background
                )
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}