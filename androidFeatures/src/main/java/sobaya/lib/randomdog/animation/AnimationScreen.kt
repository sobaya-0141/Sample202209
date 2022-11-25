package sobaya.lib.randomdog.animation

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.commandiron.animatable_compose.AnimatableSpacer
import com.commandiron.animatable_compose.AnimatableText
import com.commandiron.animatable_compose.state.rememberAnimatableSpacerState
import com.commandiron.animatable_compose.state.rememberAnimatableTextState
import com.commandiron.animatable_compose.state.rememberSharedAnimatableState

@Composable
fun AnimationScreenRoute(modifier: Modifier = Modifier) {
    AnimationScreen(modifier)
}

@Composable
private fun AnimationScreen(modifier: Modifier = Modifier) {
    val spacerState = rememberAnimatableSpacerState(
        initialSize = DpSize(0.dp, 0.dp),
        targetSize = DpSize(40.dp, 40.dp),
        toTargetSizeAnimationSpec = tween(500, 100)
    )
    val textState = rememberAnimatableTextState(
        targetFontSize = 34.sp,
        initialFontSize = 1.sp,
        toInitialAlphaAnimationSpec = tween(500, 500)
    )
    val sharedAnimatableState = rememberSharedAnimatableState(
        listOf(
            spacerState,
            textState
        )
    )

    Column(modifier.fillMaxSize()) {
        Button(
            onClick = {
                sharedAnimatableState.animate()
            }
        ) {
            Text(text = "アニメーション")
        }
        AnimatableSpacer(state = spacerState)
        AnimatableText(text = "Animation", state = textState)
    }
}