package sobaya.app.repository

import kotlinx.coroutines.flow.Flow
import sobaya.app.data.dogApi.response.RandomDogResponse
import sobaya.app.network.service.DogApi

class DogRepository(
    private val dogApi: DogApi
) {
    fun getRandomDog(): Flow<RandomDogResponse> = dogApi.getRandomDog()
}
