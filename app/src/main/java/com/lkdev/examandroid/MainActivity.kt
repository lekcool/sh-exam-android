package com.lkdev.examandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.socket.client.Socket
import io.socket.emitter.Emitter

class MainActivity : AppCompatActivity(), Emitter.Listener {

    private var mSocket: Socket? = null

    private var badge = 0

    private lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        initSocket()
    }

    private fun init() {
        navView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }

    private fun initSocket() {
        mSocket = App.mSocket

        mSocket?.on(Socket.EVENT_CONNECT) {
            runOnUiThread {
                Log.d("MainActivity", "EVENT_CONNECT args: ${it.firstOrNull()}")
            }
        }

        mSocket?.on(Socket.EVENT_CONNECT_ERROR) {
            runOnUiThread {
                Log.e("MainActivity", "EVENT_CONNECT_ERROR args: ${it.firstOrNull()}")
            }
        }

        mSocket?.on(Socket.EVENT_DISCONNECT) {
            runOnUiThread {
                Log.d("MainActivity", "EVENT_DISCONNECT args: ${it.firstOrNull()}")
            }
        }

        mSocket?.on("new-notification", this)
        mSocket?.connect()
    }

    override fun onDestroy() {
        super.onDestroy()
        mSocket?.disconnect()
        mSocket?.off("new-notification", this)
    }

    override fun call(vararg args: Any?) {
        runOnUiThread {
            Log.d("MainActivity", "EVENT_DISCONNECT args: ${args.firstOrNull()}")
            badge++
            addBadge(badge)
        }
    }

    private fun addBadge(badge: Int) {
        navView.getOrCreateBadge(R.id.navigation_profile).apply {
            number = badge
        }
    }
}