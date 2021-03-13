package com.lkdev.examandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.socket.client.Socket
import io.socket.emitter.Emitter

class MainActivity : AppCompatActivity(), Emitter.Listener {

    private var mSocket: Socket? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        initSocket()
    }

    private fun init() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_wallet, R.id.navigation_achievement
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun initSocket() {
        mSocket = App.mSocket

        mSocket?.on(Socket.EVENT_CONNECT) {
            mSocket?.connected()
            Log.d("new-notification", "EVENT_CONNECT args: $it")
        }

        mSocket?.on(Socket.EVENT_CONNECT_ERROR) {
            Log.d("new-notification", "EVENT_CONNECT_ERROR args: $it")
        }

        mSocket?.on(Socket.EVENT_DISCONNECT) {
            Log.d("new-notification", "EVENT_DISCONNECT args: $it")
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
        Log.d("new-notification", "args: $args")
    }
}