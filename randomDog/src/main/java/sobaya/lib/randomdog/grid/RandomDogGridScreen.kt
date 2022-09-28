package sobaya.lib.randomdog.grid

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import sobaya.app.data.dogApi.response.RandomDogResponse
import sobaya.app.util.Result

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
                columns = GridCells.Adaptive(minSize = 128.dp),
                modifier = modifier.fillMaxSize()
            ) {
                items(state.data.message) { message ->
                    AsyncImage(
                        model = message,
                        contentDescription = "dog",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onClickImage(message)
                            }
                    )
                }
            }
        }
    }
}
