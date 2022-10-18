package sobaya.app.sample202209.data.dogApi.response

@kotlinx.serialization.Serializable
data class RandomDogResponse(
    val message: List<String>,
    val status: String
)
