package sobaya.app.sample202209.usecase

import kotlinx.coroutines.flow.Flow
import sobaya.app.sample202209.data.dogApi.response.RandomDogResponse
import sobaya.app.sample202209.repository.DogRepository
import sobaya.app.sample202209.util.Result
import sobaya.app.sample202209.util.asResult

class GetRandomDogUseCase(
    private val dogRepository: DogRepository
) {
    operator fun invoke(limit: Int): Flow<Result<RandomDogResponse>> =
        dogRepository.getRandomDog(limit).asResult()
}
