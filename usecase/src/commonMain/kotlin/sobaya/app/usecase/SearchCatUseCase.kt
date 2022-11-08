package sobaya.app.usecase

import kotlinx.coroutines.flow.Flow
import sobaya.app.data.dogApi.response.CatSearchResponseItem
import sobaya.app.repository.CatRepository
import sobaya.app.util.Result
import sobaya.app.util.asResult

class SearchCatUseCase(
    private val catRepository: CatRepository
) {
    operator fun invoke(limit: Int, page: Int): Flow<Result<List<CatSearchResponseItem>>> =
        catRepository.searchCat(limit, page).asResult()
}