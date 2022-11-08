package sobaya.app.usecase

import com.kuuurt.paging.multiplatform.Pager
import com.kuuurt.paging.multiplatform.PagingConfig
import com.kuuurt.paging.multiplatform.PagingData
import com.kuuurt.paging.multiplatform.PagingResult
import com.kuuurt.paging.multiplatform.helpers.cachedIn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import sobaya.app.data.dogApi.response.SearchCatResponseItem
import sobaya.app.repository.CatRepository

class SearchCatUseCase(
    private val catRepository: CatRepository,
    private val coroutineScope: CoroutineScope
) {
    companion object {
        const val PAGE_LIMIT = 10
    }

    private val pager: Pager<Int, SearchCatResponseItem> = Pager(
        clientScope = coroutineScope,
        config = PagingConfig(
            pageSize = PAGE_LIMIT,
            enablePlaceholders = false
        ),
        initialKey = 0,
        getItems = { currentKey, size ->
            val items = catRepository.searchCat(10, currentKey)
            PagingResult(
                items = items,
                currentKey = currentKey,
                prevKey = {
                    if (currentKey > 0) {
                        currentKey - 1
                    } else {
                        null
                    }
                },
                nextKey = {
                    if (PAGE_LIMIT == items.size) {
                        currentKey + 1
                    } else {
                        null
                    }
                }
            )
        }
    )

    operator fun invoke(): Flow<PagingData<SearchCatResponseItem>> =
        pager.pagingData.cachedIn(coroutineScope)
}