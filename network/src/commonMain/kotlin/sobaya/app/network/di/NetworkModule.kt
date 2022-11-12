package sobaya.app.network.di

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.builtin.FlowRequestConverter
import de.jensklingenberg.ktorfit.create
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import sobaya.app.network.service.CatApi
import sobaya.app.network.service.DogApi

val ktorfitBuilder = Ktorfit
    .Builder()
    .httpClient(
        HttpClient {
            install(ContentNegotiation) {
                json(Json { isLenient = true; ignoreUnknownKeys = true })
                install(Logging)
            }
        }
    )
    .requestConverter(
        FlowRequestConverter()
    )
    .responseConverter()

val dogKtorfit = ktorfitBuilder.baseUrl("https://dog.ceo/api/").build()
val catKtorfit = ktorfitBuilder.baseUrl("https://api.thecatapi.com/").build()

val dogApi = dogKtorfit.create<DogApi>()
val catApi = catKtorfit.create<CatApi>()
