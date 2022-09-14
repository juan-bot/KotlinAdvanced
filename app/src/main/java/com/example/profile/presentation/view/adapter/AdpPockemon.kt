package com.example.profile.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.profile.R
import com.example.profile.presentation.presenter.Chat
import java.lang.Exception

class AdpPockemon(private val chats: List<Chat>) : RecyclerView.Adapter<AdpPockemon.ViewHolder>(), Filterable {

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
        holder.bind(chatFilterable[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(chat: Chat) {
            when (chat.type.value) {
                0 -> {
                    val tvMensage: TextView = itemView.findViewById(R.id.tvMessageSent)
                    val tvDate: TextView = itemView.findViewById(R.id.tvDataSent)
                    val cbChecked: CheckBox = itemView.findViewById(R.id.chbPockemon)
                    cbChecked.setOnCheckedChangeListener { _, b ->
                        chat.checked = b
                    }
                    tvMensage.text = chat.message
                    tvDate.text = chat.date
                    cbChecked.setChecked(chat.checked)
                }
            }
        }
    }
    override fun getItemCount() = chatFilterable.size
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(query: CharSequence?): FilterResults {
                val inputText = query.toString()
                chatFilterable = if (inputText.isEmpty()) {
                    chats
                } else {
                    var chatFilterableTemp: MutableList<Chat> = ArrayList()
                    chatFilterableTemp.clear()

                    chatFilterable.forEach {
                        if (it.message.contains(inputText)) {
                            chatFilterableTemp.add(it)
                        }
                    }
                    chatFilterableTemp
                }
                val filterResult = FilterResults()
                filterResult.values = chatFilterable
                return filterResult
            }
            override fun publishResults(query: CharSequence?, results: FilterResults?) {
                chatFilterable = results?.values as List<Chat>
                notifyDataSetChanged()
            }
        }
    }
}
