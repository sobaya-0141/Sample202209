package sobaya.app.network.service

import de.jensklingenberg.ktorfit.http.GET
import kotlinx.coroutines.flow.Flow
import sobaya.app.data.dogApi.response.RandomDogResponse

interface DogApi {
//    @GET("breeds/image/random")
//    suspend fun getRandomDog(): RandomDogResponse

    @GET("breeds/image/random")
    fun getRandomDog(): Flow<RandomDogResponse>
}
