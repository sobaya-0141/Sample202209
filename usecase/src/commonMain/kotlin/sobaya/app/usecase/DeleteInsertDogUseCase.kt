package sobaya.app.usecase

import sobaya.app.repository.DogRepository

class DeleteInsertDogUseCase(
    private val dogRepository: DogRepository
) {
    operator fun invoke(message: String, status: String) {
        dogRepository.deleteDog()
        dogRepository.insertDog(message, status)
    }
}