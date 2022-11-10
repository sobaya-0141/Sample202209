package sobaya.app.usecase

import kotlinx.coroutines.flow.Flow
import sobaya.app.data.dogApi.response.RandomDogResponse
import sobaya.app.repository.DogRepository
import sobaya.app.util.FlowResult
import sobaya.app.util.asFlowResult

class GetRandomDogUseCase(
    private val dogRepository: DogRepository
) {
    operator fun invoke(limit: Int): Flow<FlowResult<RandomDogResponse>> =
        dogRepository.getRandomDog(limit).asFlowResult()
}
