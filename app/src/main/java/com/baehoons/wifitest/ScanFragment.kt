package com.baehoons.wifitest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_scan.*
import kotlinx.android.synthetic.main.item_wifi_scan.*


class ScanFragment : Fragment() {
    private lateinit var managePermissions: ManagePermissions
    private val requestCode  = 123
    private val TAG = "WIFI_TAG"
    private var resultList = ArrayList<ScanResult>()
    lateinit var adapter: WifiAdapter
    var navController: NavController?=null

    private val wifiManager: WifiManager
        get() = context?.getSystemService(Context.WIFI_SERVICE) as WifiManager

    private val wifiReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            unregisterReceiver(this)
            Log.d(TAG, "unregisterReceiver")

            val success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
            Log.d(TAG, "intent.getBooleanExtra")
            if (success) {
                scanSuccess()
                Log.d(TAG, "scan successful")
            }
            else {
                scanFailure()
                Log.d(TAG, "scan failed")
            }

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        button_scan.setOnClickListener {
            adapter.submitList(arrayListOf())
            scanWifiNetworks()
        }
        wifiManager = context?.getSystemService(Context.WIFI_SERVICE) as WifiManager
        adapter = WifiAdapter()
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapter
    }

    private fun scanWifiNetworks() {
        registerReceiver(wifiReceiver, IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
        val success = wifiManager.startScan()
        if (!success) {
            scanFailure()
        }
        Toast.makeText(context, "Scanning", Toast.LENGTH_SHORT).show()
    }

    private fun scanFailure() {
        Toast.makeText(context, "Scan failure", Toast.LENGTH_SHORT).show()
    }
    private var wifiReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d(TAG, "onReceive " + wifiManager.scanResults.size)
            unregisterReceiver(this)
            adapter.submitList(wifiManager.scanResults)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scan,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        scan_item.setOnClickListener{
            navController!!.navigate(R.id.action_scanFragment_to_connectingFragment)
        }



    }


}