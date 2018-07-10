package io.ktorio.ktor.samples

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class Trending {
    private val client = HttpClient()

    suspend fun top(): String = request("topstories")

    /** Callback API **/

    fun top(block: (String) -> Unit, catch: (Throwable) -> Unit) = wrap(block, catch) { top() }

    fun top(block: (String) -> Unit) = wrap(block, {}) { top() }

    private suspend fun request(command: String): String = client.get {
        url {
            protocol = URLProtocol.HTTPS
            host = "hacker-news.firebaseio.com"
            encodedPath = "/v0/$command.json"
            port = 443
        }
    }
}
