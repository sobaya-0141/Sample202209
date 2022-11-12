package sobaya.app.repository

import sobaya.app.data.dogApi.response.SearchCatResponseItem
import sobaya.app.network.service.CatApi

class CatRepository(
    private val catApi: CatApi
) {
    suspend fun searchCat(limit: Int, page: Int): List<SearchCatResponseItem> {
        return catApi.searchCat(limit, page)
    }
}
