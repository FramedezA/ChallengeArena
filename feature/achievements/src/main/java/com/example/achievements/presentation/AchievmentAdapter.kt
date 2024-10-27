package com.example.achievements.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.achievements.R
import com.example.achievements.data.data_structures.Achievement


class AchievmentAdapter(
    val challenges: List<Achievement>,
) :
    RecyclerView.Adapter<AchievmentAdapter.EntryHolder>() {
    inner class EntryHolder(item: View) : RecyclerView.ViewHolder(item) {
        val titleTextView: TextView = item.findViewById(R.id.descriptionTextView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.achievment_item, parent, false)
        return EntryHolder(view)
    }

    override fun getItemCount(): Int {
        return challenges.size
    }

    override fun onBindViewHolder(holder: EntryHolder, position: Int) {
        val element = challenges[position]

        holder.titleTextView.text = element.name


    }

}