package sobaya.lib.randomdog.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import sobaya.app.randomdog.detail.RandomDogDetailUiState
import sobaya.app.randomdog.detail.RandomDogDetailViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun RandomDogDetailScreenRoute(
    viewModel: RandomDogDetailViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle()

    RandomDogDetailScreen(
        state = state.value,
        modifier = modifier
    )
}

@Composable
private fun RandomDogDetailScreen(
    state: RandomDogDetailUiState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = state.message,
            contentDescription = "dog",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
