package sobaya.lib.randomdog.animation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest


@Composable
fun AnimationScreenRoute(modifier: Modifier = Modifier) {
    AnimationScreen(modifier)
}

@Composable
private fun AnimationScreen(modifier: Modifier = Modifier) {
    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data("https://avatars.githubusercontent.com/u/45986582?v=4")
        .build()
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 3f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    AsyncImage(
        model = imageRequest,
        contentDescription = null,
        modifier = Modifier.graphicsLayer {
            scaleX = scale
            scaleY = scale
            rotationY = rotation
        },

    )
}

/*
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
 */