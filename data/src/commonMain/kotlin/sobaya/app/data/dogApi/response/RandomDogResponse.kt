package sobaya.app.data.dogApi.response

import kotlinx.serialization.Serializable

@Serializable
data class RandomDogResponse(
    val message: List<String>,
    val status: String
)
