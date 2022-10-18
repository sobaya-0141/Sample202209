package sobaya.lib.randomdog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import sobaya.app.sample202209.data.dogApi.response.RandomDogResponse
import sobaya.app.sample202209.features.randomDog.RandomDogViewModel
import sobaya.app.sample202209.util.Result

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun RandomDogScreenRout(
    navController: NavController,
    viewModel: RandomDogViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.randomDog.collectAsStateWithLifecycle()
    RandomDogScreen(
        state = state,
        onClickReload = viewModel::fetchRandomDog,
        modifier
    )
}

@Composable
private fun RandomDogScreen(
    state: Result<RandomDogResponse>,
    onClickReload: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (state) {
        Result.Loading -> {
            Text("Loading")
        }
        is Result.Success -> {
            AsyncImage(
                model = state.data.message,
                contentDescription = "dog",
                modifier = modifier.fillMaxSize()
            )
        }
        is Result.Error -> {
            Text(state.exception?.message ?: "")
        }
    }
}
