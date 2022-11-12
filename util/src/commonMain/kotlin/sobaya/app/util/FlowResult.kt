package sobaya.app.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface FlowResult<out T> {
    data class Success<T>(val data: T) : FlowResult<T>
    data class Error(val exception: Throwable? = null) : FlowResult<Nothing>
    object Loading : FlowResult<Nothing>
}

fun <T> Flow<T>.asFlowResult(): Flow<FlowResult<T>> {
    return this
        .map<T, FlowResult<T>> {
            FlowResult.Success(it)
        }
        .onStart {
            emit(FlowResult.Loading)
        }
        .catch {
            emit(FlowResult.Error(it))
        }
}
