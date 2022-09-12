package com.example.profile.presentation.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.profile.R
import com.example.profile.presentation.presenter.Chat
import java.lang.Exception

class AdpPockemon(chats: List<Chat>) : RecyclerView.Adapter<AdpPockemon.ViewHolder>() {

    private var chatFilterable: List<Chat> = chats
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayout = when (viewType) {
            0 -> R.layout.item_pockemon
            else -> throw Exception("invalid type")
        }
        val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return chatFilterable[position].type.value
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*val chat = chats[position]
        holder.tvMensage.text = chat.message
        holder.tvDate.text = chat.date*/
        holder.bind(chatFilterable[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(chat: Chat) {
            when (chat.type.value) {
                0 -> {
                    val tvMensage: TextView = itemView.findViewById(R.id.tvMessageSent)
                    val tvDate: TextView = itemView.findViewById(R.id.tvDataSent)
                    tvMensage.text = chat.message
                    tvDate.text = chat.date
                }
            }
        }
    }
    override fun getItemCount() = chatFilterable.size
}
