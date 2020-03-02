package com.baehoons.wifitest

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_wifi_scan.view.*

class WifiAdapter : RecyclerView.Adapter<WifiAdapter.DeviceHolder>() {

    var onDeviceClickListener: ((ScanResult) -> Unit)? = null

    private var devices = ArrayList<ScanResult>()
    class DeviceHolder(parent:ViewGroup):RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_wifi_scan,parent,false))
    {
        fun onBind(scanResult: ScanResult,onDeviceClickListener: (ScanResult)->Unit){
            itemView.run{
                var ssid:String = scanResult.SSID
                text_wifi_name.text = ssid

                scan_item.setOnClickListener {
                    onDeviceClickListener.invoke(scanResult)
                }
            }

//            fun create(parent: ViewGroup): ViewHolder {
//                return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_wifi_scan,  parent,false))
//            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DeviceHolder (
        parent
    )

    override fun getItemCount() = devices.size

    override fun onBindViewHolder(viewHolder: DeviceHolder, position: Int) {
        viewHolder.onBind(devices[position]){
            onDeviceClickListener?.invoke(it)
        }

    }

    fun addDevice(device: ScanResult) {

        devices.add(device)
        notifyDataSetChanged()




    }

    fun clearDevices() {
        devices.clear()
        notifyDataSetChanged()
    }




//    companion object {
//        val DIFF_UTIL = object : DiffUtil.ItemCallback<ScanResult>() {
//
//            override fun areItemsTheSame(p0: ScanResult, p1: ScanResult): Boolean {
//                return false
//            }
//
//            @SuppressLint("DiffUtilEquals")
//            override fun areContentsTheSame(p0: ScanResult, p1: ScanResult): Boolean {
//                return p0 == p1
//            }
//        }
//    }
}