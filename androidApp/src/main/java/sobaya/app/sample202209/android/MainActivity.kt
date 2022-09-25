package sobaya.app.sample202209.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.android.ext.android.get
import sobaya.app.sample202209.android.theme.SampleTheme
import sobaya.lib.randomdog.RandomDogScreenRout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(navController = navController, startDestination = "menuScreeen") {
                        composable("randomDog") {
                            RandomDogScreenRout(
                                navController = navController,
                                viewModel = get(),
                                modifier = Modifier
                            )
                        }
                        composable("menuScreeen") {
                            MenuScreenRoute(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
internal fun MenuScreenRoute(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    MenuScreen(
        onClickRandomDog = {
            navController.navigate("randomDog")
        },
        modifier = modifier
    )
}

@Composable
private fun MenuScreen(
    onClickRandomDog: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable {
                    onClickRandomDog()
                }
        ) {
            Text(
                text = "RandomDog",
                style = androidx.compose.material3.MaterialTheme.typography.titleMedium
            )
        }
    }
}
