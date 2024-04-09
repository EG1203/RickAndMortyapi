package com.example.rickandmortyapi

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.characterNameTextView)

    fun bind(character: GameCharacter) {
        nameTextView.text = character.name
        // Здесь можно добавить загрузку изображений, например, с Glide или Picasso
    }
}
