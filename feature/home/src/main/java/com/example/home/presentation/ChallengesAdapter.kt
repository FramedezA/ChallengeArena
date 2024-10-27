package com.example.home.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.home.R
import com.example.home.data.data_structures.Challenge


class ChallengesAdapter(
    val challenges: List<Challenge>,
    val listener: ChallengeClickListener
) :
    RecyclerView.Adapter<ChallengesAdapter.EntryHolder>() {
    inner class EntryHolder(item: View) : RecyclerView.ViewHolder(item), View.OnClickListener {
        val titleTextView: TextView = item.findViewById(R.id.titleTextView)
        val rulesTextView: TextView = item.findViewById(R.id.rulesTextView)
        val typeImageView: ImageView = item.findViewById(R.id.challengeTypeImageView)
        val card: CardView = item.findViewById(R.id.challengeCard)

        init {
            card.setOnClickListener(::onClick)
        }



        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                Log.d("mLog", "$position,${challenges.size}")
                listener.onClick(challenges[position])

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.challenge_item_home, parent, false)
        return EntryHolder(view)
    }

    override fun getItemCount(): Int {
        return challenges.size
    }

    override fun onBindViewHolder(holder: EntryHolder, position: Int) {
        val element = challenges[position]
        holder.titleTextView.text = element.title
        holder.rulesTextView.text = element.rules
        if (element.type == "team") {
            holder.typeImageView.setImageResource(R.drawable.users_02)
        } else {
            holder.typeImageView.setImageResource(R.drawable.user)
        }

    }

    interface ChallengeClickListener {
        fun onClick(challenge: Challenge)
    }
}