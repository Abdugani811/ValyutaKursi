package com.example.valyutakursi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CurrencyAdapter (
    private val items: List<CurrencyRate>,
    private val onClick: (CurrencyRate) -> Unit
) : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.ccyTv)
        val tvCcyNmUZ: TextView = view.findViewById(R.id.CcyNmUZTv)
        val tvRate: TextView = view.findViewById(R.id.rateTv)
        val tvDiff: TextView = view.findViewById(R.id.diffTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvName.text = "${item.Ccy}"
        holder.tvCcyNmUZ.text = "${item.CcyNm_UZ}"
        holder.tvRate.text = "${item.Rate} UZS"
        holder.tvDiff.text = "${item.Diff}%"
        holder.itemView.setOnClickListener { onClick(item) }
    }
}
