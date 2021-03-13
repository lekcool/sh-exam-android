package com.lkdev.examandroid

import android.app.Application
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

class App : Application() {

    init {
        mSocket = try {
            IO.socket("https://px-socket-api.herokuapp.com")
        } catch (e: URISyntaxException) {
            throw e
        }
    }

    companion object {
        var mSocket: Socket? = null
    }
}