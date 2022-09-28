package sobaya.app.network.service

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import kotlinx.coroutines.flow.Flow
import sobaya.app.data.dogApi.response.RandomDogResponse

interface DogApi {
//    @GET("breeds/image/random")
//    suspend fun getRandomDog(): RandomDogResponse

    @GET("breeds/image/random/{limit}")
    fun getRandomDog(@Path("limit") limit: Int): Flow<RandomDogResponse>
}
