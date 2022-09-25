package sobaya.app.network.di

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.builtin.FlowRequestConverter
import de.jensklingenberg.ktorfit.converter.builtin.FlowResponseConverter
import de.jensklingenberg.ktorfit.create
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import sobaya.app.network.service.DogApi

val ktorfit = Ktorfit
    .Builder()
    .baseUrl("https://dog.ceo/api/")
    .httpClient(
        HttpClient() {
            install(ContentNegotiation) {
                json(Json { isLenient = true; ignoreUnknownKeys = true })
            }
        }
    )
    .requestConverter(
        FlowRequestConverter()
    )
    .responseConverter(
    )
    .build()
val dogApi = ktorfit.create<DogApi>()
