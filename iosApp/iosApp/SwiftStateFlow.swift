//
//  SwiftStateFlow.swift
//  iosApp
//
//  Created by sobaya-0141 on 2022/09/30.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation

class SwiftStateFlow<T>(private val kotlinStateFlow: StateFlow<T>) : Flow<T> by kotlinStateFlow {
    val value = kotlinStateFlow.value
    var job: Job? = null

    fun observe(continuation: ((T) -> Unit)) {
        kotlinStateFlow.onEach {
            continuation(it)
        }.launchIn(
            CoroutineScope(Dispatchers.Main + Job().also { job = it })
        )
    }

    fun close() {
        job?.cancel()
        job = null
    }
}
