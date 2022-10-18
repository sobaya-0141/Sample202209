package sobaya.app.sample202209.usecase

import kotlinx.coroutines.flow.Flow
import sobaya.app.sample202209.repository.DogRepository
import sobaya.lib.local.Dog

class SelectDogUseCase(
    private val dogRepository: DogRepository
) {
    operator fun invoke(): Flow<List<Dog>> = dogRepository.selectDog()
}
