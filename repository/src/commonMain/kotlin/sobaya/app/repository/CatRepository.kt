package sobaya.app.repository

import kotlinx.coroutines.flow.Flow
import sobaya.app.data.dogApi.response.CatSearchResponseItem
import sobaya.app.network.service.CatApi

class CatRepository(
    private val catApi: CatApi
) {
    fun searchCat(limit: Int, page: Int): Flow<List<CatSearchResponseItem>> =
        catApi.searchCat(limit, page)
}
