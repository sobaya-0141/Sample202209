package sobaya.app.features.searchCat

import com.kuuurt.paging.multiplatform.PagingData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import sobaya.app.data.dogApi.response.SearchCatResponseItem
import sobaya.app.usecase.SearchCatUseCase

class SearchCatViewModel(): ViewModel(), KoinComponent {
    private val searchCatUseCase: SearchCatUseCase by inject { parametersOf(viewModelScope) }
    val catData: Flow<PagingData<SearchCatResponseItem>> = searchCatUseCase()
}