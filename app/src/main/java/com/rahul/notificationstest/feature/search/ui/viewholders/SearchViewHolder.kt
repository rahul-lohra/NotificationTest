package com.rahul.notificationstest.feature.search.ui.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rahul.notificationstest.R

class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textView = view.findViewById<TextView>(R.id.text_view)

    fun bind(text: String) {
        textView.text = text
    }
}