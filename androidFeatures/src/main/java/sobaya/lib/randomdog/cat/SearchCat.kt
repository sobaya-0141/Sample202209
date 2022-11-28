package sobaya.lib.randomdog.cat

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import kotlinx.coroutines.flow.Flow
import sobaya.app.data.dogApi.response.SearchCatResponseItem
import sobaya.app.features.searchCat.SearchCatViewModel

@Composable
fun SearchCatRoute(
    viewModel: SearchCatViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val catData = (viewModel.catData as Flow<PagingData<SearchCatResponseItem>>).collectAsLazyPagingItems()
    SearchCat(catData = catData)
}

@Composable
private fun SearchCat(
    catData: LazyPagingItems<SearchCatResponseItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(catData) { cat ->
            AsyncImage(model = cat?.url, contentDescription = "cat")
        }
    }
}