package sobaya.app.usecase

import kotlinx.coroutines.flow.Flow
import sobaya.app.repository.DogRepository
import sobaya.lib.local.Dog

class SelectDogUseCase(
    private val dogRepository: DogRepository
) {
    operator fun invoke(): Flow<List<Dog>> = dogRepository.selectDog()
}