package sobaya.app.repository.paging

import app.cash.paging.PagingSource
import app.cash.paging.PagingSourceLoadParams
import app.cash.paging.PagingSourceLoadResult
import app.cash.paging.PagingSourceLoadResultPage
import app.cash.paging.PagingState
import sobaya.app.data.dogApi.response.SearchCatResponseItem
import sobaya.app.repository.CatRepository

class SearchCatPagingSource(
    private val catRepository: CatRepository,
) : PagingSource<Int, SearchCatResponseItem>() {

    override fun getRefreshKey(state: PagingState<Int, SearchCatPagingSource>): Int? = null

    override suspend fun load(params: PagingSourceLoadParams<Int>): PagingSourceLoadResult<Int, SearchCatResponseItem> {
        val page = params.key ?: FIRST_PAGE_INDEX
        val next = page + 1
        val prev = if (page == FIRST_PAGE_INDEX) null else page - 1
        val data = catRepository.searchCat(PAGE_LIMIT, page)

        return PagingSourceLoadResultPage(
            data = data,
            prevKey = prev,
            nextKey = next
        ) as PagingSourceLoadResult<Int, SearchCatResponseItem>
    }

    companion object {
        const val FIRST_PAGE_INDEX = 0
        const val PAGE_LIMIT = 10
    }
}