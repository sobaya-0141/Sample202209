package sobaya.app.data.dogApi.response

import kotlinx.serialization.Serializable

@Serializable
data class SearchCatResponseItem(
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)