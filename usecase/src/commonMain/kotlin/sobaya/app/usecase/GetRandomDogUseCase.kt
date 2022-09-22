package sobaya.app.usecase

import kotlinx.coroutines.flow.Flow
import sobaya.app.data.dogApi.response.RandomDogResponse
import sobaya.app.repository.DogRepository
import sobaya.app.util.asResult

class GetRandomDogUseCase(
    private val dogRepository: DogRepository
) {
    operator fun invoke(): Flow<sobaya.app.util.Result<RandomDogResponse>> =
        dogRepository.getRandomDog().asResult()
}