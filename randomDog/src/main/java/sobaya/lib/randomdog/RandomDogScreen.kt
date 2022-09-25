package sobaya.lib.randomdog

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.compose.AsyncImage
import sobaya.app.data.dogApi.response.RandomDogResponse
import sobaya.app.util.Result

@Composable
fun RandomDogScreenRout(
    navController: NavController,
    viewModel: RandomDogViewModel,
    modifier: Modifier = Modifier
) {
    val state: State<Result<RandomDogResponse>> = viewModel.randomDog.collectAsState()
    RandomDogScreen(
        state = state,
        onClickReload = viewModel::fetchRandomDog,
        modifier
    )
}

@Composable
internal fun RandomDogScreen(
    state: State<Result<RandomDogResponse>>,
    onClickReload: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (val result = state.value) {
        Result.Loading -> {
            Text("Loading")
        }
        is Result.Success -> {
            AsyncImage(
                model = result.data.message,
                contentDescription = "dog"
            )
        }
        is sobaya.app.util.Result.Error -> {
            Text(result.exception?.message ?: "")
        }
    }
}
