package sobaya.lib.randomdog.grid

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import sobaya.app.data.dogApi.response.RandomDogResponse
import sobaya.app.util.Result
import sobaya.app.util.ifTrue

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun RandomDogGridScreenRoute(
    navController: NavController,
    viewModel: RandomDogGridViewModel,
    modifier: Modifier = Modifier
) {
    val uiState: State<Result<RandomDogResponse>> = viewModel.randomDog.collectAsStateWithLifecycle()

    RandomDogGridScreen(
        uiState = uiState,
        onClickImage = viewModel::onClickDog,
        modifier = modifier
    )

    LaunchedEffect(viewModel.isDataCreated) {
        viewModel.isDataCreated?.let {
            viewModel.setIsDataCreated(null)
            navController.navigate("randomDogDetail")
        }
    }
}

@Composable
private fun RandomDogGridScreen(
    uiState: State<Result<RandomDogResponse>>,
    onClickImage: (message: String) -> Unit,
    modifier: Modifier = Modifier
) {
    val state = uiState.value
    when (state) {
        Result.Loading -> {

        }
        is Result.Error -> {

        }
        is Result.Success -> {
            LazyVerticalGrid(
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
                    items = state.data.message
                ) { message ->
                    AsyncImage(
                        model = message,
                        contentDescription = "dog",
                        Modifier
                            .width(128.dp)
                            .height(128.dp)
                            .padding(4.dp)
                            .ifTrue(false) {
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
