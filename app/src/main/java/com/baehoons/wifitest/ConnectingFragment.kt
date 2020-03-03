package com.baehoons.wifitest

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_connecting.*
import java.text.SimpleDateFormat
import java.util.*


class ConnectingFragment : Fragment() {

    lateinit var ssid :String
    lateinit var bssid :String
    lateinit var level :String
    lateinit var frequency :String
    lateinit var capabilities :String
    private val format:String ="yyyy년 MM월 dd일 HH시 mm분"
    private var sdf = SimpleDateFormat(format, Locale.KOREA)
    private val times = sdf.format(Date())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ssid = arguments!!.getString("ssid").toString()
        bssid=arguments!!.getString("bssid").toString()
        level=arguments!!.getString("level").toString()
        frequency=arguments!!.getString("frequency").toString()
        capabilities=arguments!!.getString("capabilities").toString()
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
        textView.text = ssid
        textView8.text = bssid
        textView7.text = level
        textView6.text = frequency
        textView10.text = capabilities
        textView2.text = times

        Log.d("joon", sdf.toString())
        Log.d("joon", times)

    }
}
