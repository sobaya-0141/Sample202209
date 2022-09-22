package sobaya.app.data.dogApi.response

import kotlinx.serialization.Serializable

@Serializable
data class RandomDogResponse(
    val message: String,
    val status: String
)