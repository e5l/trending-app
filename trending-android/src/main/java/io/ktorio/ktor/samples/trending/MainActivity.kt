package io.ktorio.ktor.samples.trending

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import io.ktor.cio.*
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktorio.ktor.samples.*
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.*
import kotlinx.coroutines.experimental.io.*
import java.net.*
import java.util.concurrent.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            println("[$thread] Exception: $throwable")
            throwable.printStackTrace()
            throw throwable
        }

        val trending = Trending()
        launch {
            val topItems = trending.top()
            println(topItems)

            withContext(UI) {
                Toast.makeText(this@MainActivity, topItems, Toast.LENGTH_LONG).show()
            }
        }

        setContentView(R.layout.activity_main)
    }
}
