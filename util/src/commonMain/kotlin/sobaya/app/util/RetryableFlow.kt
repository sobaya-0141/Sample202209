package sobaya.app.util


import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.onEach

@FlowPreview
fun <T> retryableFlow(retryTrigger: RetryTrigger, flowProvider: () -> Flow<T>) =
    retryTrigger.retryEvent.filter { it == RetryTrigger.State.RETRYING }
        .flatMapConcat { flowProvider() }
        .onEach { retryTrigger.retryEvent.value = RetryTrigger.State.IDLE }

class RetryTrigger {
    enum class State { RETRYING, IDLE }

    val retryEvent = MutableStateFlow(State.RETRYING)

    fun retry() {
        retryEvent.value = State.RETRYING
    }
}