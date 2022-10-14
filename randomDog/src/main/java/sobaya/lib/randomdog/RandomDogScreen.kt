package sobaya.lib.randomdog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import coil.compose.AsyncImage
import sobaya.app.data.dogApi.response.RandomDogResponse
import sobaya.app.features.randomDog.RandomDogViewModel
import sobaya.app.util.Result

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

@Composable
@Preview
fun RandomDogScreenPreview() {
    RandomDogScreen(
        state = remember { mutableStateOf(Result.Loading) },
        onClickReload = {}
    )
}
