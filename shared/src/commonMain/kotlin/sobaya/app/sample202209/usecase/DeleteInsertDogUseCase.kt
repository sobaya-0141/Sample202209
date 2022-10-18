package sobaya.app.sample202209.usecase

import sobaya.app.sample202209.repository.DogRepository

class DeleteInsertDogUseCase(
    private val dogRepository: DogRepository
) {
    operator fun invoke(message: String, status: String) {
        dogRepository.deleteDog()
        dogRepository.insertDog(message, status)
    }
}
