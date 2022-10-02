package sobaya.app.sample202209

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach

/**
 * flow extension to be used with combine framework in swift ui
 */

fun Flow<*>.subscribe(
    onEach: (item: Any) -> Unit,
    onComplete: () -> Unit,
    onThrow: (error: Throwable) -> Unit
): Job = this.subscribe(Dispatchers.Main, onEach, onComplete, onThrow)

fun Flow<*>.subscribe(
    dispatcher: CoroutineDispatcher,
    onEach: (item: Any) -> Unit,
    onComplete: () -> Unit,
    onThrow: (error: Throwable) -> Unit
): Job =
    this.onEach { onEach(it as Any) }
        .catch { onThrow(it) }
        .onCompletion { onComplete() }
        .launchIn(CoroutineScope(Job() + dispatcher))
