package com.lkdev.examandroid

import android.app.Application
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

class App : Application() {

    companion object {
        var mSocket: Socket? = null
            get() {
                synchronized(this) {
                    if (field == null) {
                        field = IO.socket("https://px-socket-api.herokuapp.com", IO.Options.builder()
                            .setReconnectionAttempts(3)
                            .setReconnectionDelay(3000)
                            .build())
                    }
                }
                return field
            }
    }
}