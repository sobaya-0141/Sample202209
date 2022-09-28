package sobaya.lib.randomdog.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun RandomDogDetailScreenRoute(
    viewModel: RandomDogDetailViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    RandomDogDetailScreen(
        state = viewModel.uiState,
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