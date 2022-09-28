package sobaya.app.data.dogApi.response

@kotlinx.serialization.Serializable
data class RandomDogResponse(
    val message: List<String>,
    val status: String
)