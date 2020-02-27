package com.baehoons.wifitest

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_connecting.*


class ConnectingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val arguments = intent.extras
//        val SSID = arguments.get("wifi-SSID").toString()
//        val BSSID = arguments.get("wifi-BSSID").toString()
//        val level = arguments.get("wifi-level").toString()
//        val frequency = arguments.get("wifi-frequency").toString()
//        val capabilities = arguments.get("wifi-capabilities").toString()
//
//        textView.setText(SSID)
//        textView6.setText(BSSID)
//        textView7.setText(level)
//        textView8.setText(frequency)
//        textView10.setText(capabilities)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_connecting, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
