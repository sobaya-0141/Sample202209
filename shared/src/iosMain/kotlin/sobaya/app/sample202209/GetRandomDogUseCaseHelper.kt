package sobaya.app.sample202209

import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import sobaya.app.data.dogApi.response.RandomDogResponse
import sobaya.app.usecase.GetRandomDogUseCase
import sobaya.app.util.Result

class GetRandomDogUseCaseHelper : KoinComponent {
    private val getRandomDogUseCase: GetRandomDogUseCase by inject()
    fun getRandomDogUseCase(): Flow<Result<RandomDogResponse>> = getRandomDogUseCase()
}