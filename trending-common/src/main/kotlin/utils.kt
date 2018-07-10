package io.ktorio.ktor.samples

import kotlinx.coroutines.experimental.*

fun <T> wrap(block: (T) -> Unit, catch: (Throwable) -> Unit, action: suspend () -> T) {
    val result = async(Unconfined) { action() }
    result.invokeOnCompletion {
        if (it != null) {
            catch(it)
            return@invokeOnCompletion
        }

        block(result.getCompleted())
    }
}