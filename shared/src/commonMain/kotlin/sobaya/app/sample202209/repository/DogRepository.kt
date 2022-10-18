package sobaya.app.sample202209.repository

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import sobaya.app.sample202209.data.dogApi.response.RandomDogResponse
import sobaya.app.sample202209.network.service.DogApi
import sobaya.lib.local.AppDatabase
import sobaya.lib.local.Dog

class DogRepository(
    private val dogApi: DogApi,
    private val database: AppDatabase
) {
    fun getRandomDog(limit: Int): Flow<RandomDogResponse> = dogApi.getRandomDog(limit)

    fun selectDog(): Flow<List<Dog>> = database.dogQueries.selectDog().asFlow().mapToList()

    fun deleteDog() = database.dogQueries.deleteDog()

    fun insertDog(message: String, status: String) = database.dogQueries.insertDog(message, status)
}
