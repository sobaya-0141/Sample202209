package sobaya.lib.randomdog.grid

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import sobaya.app.data.dogApi.response.RandomDogResponse
import sobaya.app.features.randomDog.grid.RandomDogGridViewModel
import sobaya.app.util.Result
import sobaya.app.util.ifTrue

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun RandomDogGridScreenRoute(
    navController: NavController,
    viewModel: RandomDogGridViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.randomDog.collectAsStateWithLifecycle()
    val isDataCreated by viewModel.isDataCreated.collectAsStateWithLifecycle()

    RandomDogGridScreen(
        uiState = uiState,
        onClickImage = viewModel::onClickDog,
        modifier = modifier
    )

    LaunchedEffect(
        isDataCreated
    ) {
        viewModel.isDataCreated.value?.let {
            viewModel.setIsDataCreated(null)
            navController.navigate("randomDogDetail")
        }
    }
}

@Composable
private fun RandomDogGridScreen(
    uiState: Result<RandomDogResponse>,
    onClickImage: (message: String) -> Unit,
    modifier: Modifier = Modifier
) {
    val gridState = rememberLazyGridState()

    when (uiState) {
        Result.Loading -> {
        }
        is Result.Error -> {
        }
        is Result.Success -> {
            LazyVerticalGrid(
                state = gridState,
                columns = GridCells.Fixed(3),
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    start = 12.dp,
                    top = 16.dp,
                    end = 12.dp,
                    bottom = 16.dp
                )
            ) {
                items(
                    items = uiState.data.message
                ) { message ->
                    AsyncImage(
                        model = message,
                        contentDescription = "dog",
                        modifier = Modifier
                            .width(128.dp)
                            .height(128.dp)
                            .padding(4.dp)
                            .ifTrue(!gridState.isScrollInProgress) {
                                clickable {
                                    onClickImage(message)
                                }
                            }
                    )
                }
            }
        }
    }
}
