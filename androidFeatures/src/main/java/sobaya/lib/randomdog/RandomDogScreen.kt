package sobaya.lib.randomdog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import sobaya.app.data.dogApi.response.RandomDogResponse
import sobaya.app.features.randomDog.RandomDogViewModel
import sobaya.app.util.FlowResult

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
    state: FlowResult<RandomDogResponse>,
    onClickReload: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (state) {
        FlowResult.Loading -> {
            Text("Loading")
        }
        is FlowResult.Success -> {
            AsyncImage(
                model = state.data.message,
                contentDescription = "dog",
                modifier = modifier.fillMaxSize()
            )
        }
        is FlowResult.Error -> {
            Text(state.exception?.message ?: "")
        }
    }
}
