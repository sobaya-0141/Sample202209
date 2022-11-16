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
import org.koin.androidx.viewmodel.ext.android.getViewModel
import sobaya.app.sample202209.android.theme.SampleTheme
import sobaya.lib.randomdog.RandomDogScreenRout
import sobaya.lib.randomdog.cat.SearchCatRoute
import sobaya.lib.randomdog.detail.RandomDogDetailScreenRoute
import sobaya.lib.randomdog.drag.DragAndDropScreenRoute
import sobaya.lib.randomdog.grid.RandomDogGridScreenRoute

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
                    NavHost(navController = navController, startDestination = "menu") {
                        composable("randomDog") {
                            RandomDogScreenRout(
                                navController = navController,
                                viewModel = getViewModel()
                            )
                        }
                        composable("menu") {
                            MenuScreenRoute(navController = navController)
                        }
                        composable("randomDogGrid") {
                            RandomDogGridScreenRoute(
                                navController = navController,
                                viewModel = getViewModel()
                            )
                        }
                        composable("randomDogDetail") {
                            RandomDogDetailScreenRoute(
                                viewModel = getViewModel(),
                                navController = navController
                            )
                        }
                        composable("searchCat") {
                            SearchCatRoute(
                                viewModel = getViewModel(),
                                navController = navController
                            )
                        }
                        composable("dragAndDrop") {
                            DragAndDropScreenRoute()
                        }
                    }
                }
            }
        }
    }
}

data class MenuActions(
    val onClickRandomDog: () -> Unit,
    val onClickRandomDogGrid: () -> Unit,
    val onClickSearchCat: () -> Unit,
    val onClickDragAndDrop: () -> Unit
)

@Composable
internal fun MenuScreenRoute(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    MenuScreen(
        MenuActions(
            onClickRandomDog = {
                navController.navigate("randomDog")
            },
            onClickRandomDogGrid = {
                navController.navigate("randomDogGrid")
            },
            onClickSearchCat = {
                navController.navigate("searchCat")
            },
            onClickDragAndDrop = {
                navController.navigate("dragAndDrop")
            }
        ),
        modifier = modifier
    )
}

@Composable
private fun MenuScreen(
    actions: MenuActions,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp)
//                .clickable {
//                    onClickRandomDog()
//                }
//        ) {
//            Text(
//                text = "RandomDog",
//                style = androidx.compose.material3.MaterialTheme.typography.titleMedium
//            )
//        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable {
                    actions.onClickRandomDogGrid()
                }
        ) {
            Text(
                text = "RandomDogGrid",
                style = androidx.compose.material3.MaterialTheme.typography.titleMedium
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable {
                    actions.onClickSearchCat()
                }
        ) {
            Text(
                text = "ネコ",
                style = androidx.compose.material3.MaterialTheme.typography.titleMedium
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable {
                    actions.onClickDragAndDrop()
                }
        ) {
            Text(
                text = "ドラッグ",
                style = androidx.compose.material3.MaterialTheme.typography.titleMedium
            )
        }
    }
}
