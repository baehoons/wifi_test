package com.baehoons.wifitest

import android.annotation.SuppressLint
import android.net.wifi.ScanResult
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_wifi_scan.view.*

class WifiAdapter  : ListAdapter<ScanResult, WifiAdapter.ViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder.create(p0)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.text_wifi_name.text = getItem(position).SSID
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_wifi_scan,  parent,false))
            }
        }
    }

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<ScanResult>() {

            override fun areItemsTheSame(p0: ScanResult, p1: ScanResult): Boolean {
                return false
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(p0: ScanResult, p1: ScanResult): Boolean {
                return p0 == p1
            }
        }
    }
}