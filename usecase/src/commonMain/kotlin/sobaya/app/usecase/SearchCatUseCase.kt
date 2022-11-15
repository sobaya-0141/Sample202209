package sobaya.app.usecase

import app.cash.paging.Pager
import app.cash.paging.PagingConfig
import app.cash.paging.PagingSource
import sobaya.app.data.dogApi.response.SearchCatResponseItem
import sobaya.app.repository.paging.SearchCatPagingSource

class SearchCatUseCase() {
    companion object {
        const val PAGE_LIMIT = 10
    }

    suspend operator fun invoke(): Pager<Int, SearchCatResponseItem> =
        Pager(PagingConfig(pageSize = 10, initialLoadSize = 10)) {
            SearchCatPagingSource() as PagingSource<Int, SearchCatResponseItem>
        }
}