package sobaya.app.features.randomDog.grid

import sobaya.app.data.dogApi.response.RandomDogResponse

data class SwRandomDogGridState(
    val error: String?,
    val data: RandomDogResponse?
) {
    val isSuccess: Boolean
        get() = error != null && data != null
    companion object {
        fun initialState() = SwRandomDogGridState(
            error = null,
            data = null
        )
    }
}