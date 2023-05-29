package sobaya.lib.randomdog.scroll

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import kotlinx.coroutines.launch

@Composable
fun ScrollScreen() {
    ColumnVer()
}

@Composable
private fun ColumnVer() {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    var positionY: Int by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        Button(
            onClick = {
                scope.launch {
                    scrollState.animateScrollTo(positionY)
                }
            }
        ) {
            Text(text = "スクロール")
        }
        (0..100).map {
            "TEXT$it"
        }.forEachIndexed { index, s ->
            if (index != 50) {
                Text(
                    text = "TEXT$s",
                    modifier = Modifier.onGloballyPositioned {
                        if (positionY < it.positionInWindow().y) {
                            positionY = it.positionInWindow().y.toInt()
                        }
                    }
                )
            } else{
                Text(text = "TEXT$s")
            }
        }
    }
}