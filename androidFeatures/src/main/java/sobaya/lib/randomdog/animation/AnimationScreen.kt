package sobaya.lib.randomdog.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlinx.coroutines.delay
import sobaya.lib.randomdog.R


@Composable
fun AnimationScreenRoute(modifier: Modifier = Modifier) {
    AnimationScreen(modifier)
}

@Composable
private fun AnimationScreen(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 3f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Text(
        text = "TEST",
        modifier = Modifier
            .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .drawBehind {

        },
    )
}
/*
@Composable
private fun AnimationScreen(modifier: Modifier = Modifier) {
    var message by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.animateContentSize()
    ) {
        Text(text = message)
        Button(
            onClick = {
                if (message.isEmpty()) {
                    message = "サイズ変更されるかどうかの確認"
                } else {
                    message = ""
                }
            }
        ) {
            Text(text = "Button")
        }
    }
}

/*
@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimationScreen(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    AnimatedContent(
        targetState = expanded,
        transitionSpec = {
            fadeIn(animationSpec = tween(150, 150)) with
                    fadeOut(animationSpec = tween(150)) using
                    SizeTransform { initialSize, targetSize ->
                        if (targetState) {
                            keyframes {
                                // Expand horizontally first.
                                IntSize(targetSize.width, initialSize.height) at 150
                                durationMillis = 300
                            }
                        } else {
                            keyframes {
                                // Shrink vertically first.
                                IntSize(initialSize.width, targetSize.height) at 150
                                durationMillis = 300
                            }
                        }
                    }
        }
    ) { isExpanded ->
        if (isExpanded) {
            Text(
                text = "あなただけ特別に退会をしないでくれたら2000ペリカプレゼントします！！\n" +
                        "なんか他にも特典つけるから退会しないでよ！ね？ね？ね？",
                modifier = Modifier.clickable {
                    expanded = !isExpanded
                }
            )
        } else {
            Button(
                onClick = {
                    expanded = !expanded
                }
            ) {
                Text(text = "退会")
            }
        }
    }
}

/*
@Composable
private fun AnimationScreen(modifier: Modifier = Modifier) {
    var isExpanded by remember { mutableStateOf(true) }
    val scale: Float by animateFloatAsState(targetValue = if (isExpanded) 1f else 0f)
    
    Column {
        Button(
            onClick = {
                isExpanded = !isExpanded
            }
        ) {
            Text(text = "拡大/縮小")
        }
        Text(
            modifier = Modifier.scale(scale),
            text = "サンプル"
        )
    }
}
*/
/*
@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimationScreen(modifier: Modifier = Modifier) {
    var editable by remember { mutableStateOf(true) }

    Column() {
        Button(
            onClick = {
                editable = !editable
            }
        ) {
            Text(text = "表示/非表示")
        }
        // 表示/非表示
        // https://developer.android.com/jetpack/compose/animation?hl=ja#animatedvisibility
        AnimatedVisibility(visible = editable) {
            Button(onClick = {}) {
                Text(text = "退会")
            }
        }
        AnimatedVisibility(
            visible = editable,
            enter = EnterTransition.None,
            exit = ExitTransition.None
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Button(
                    modifier = Modifier.animateEnterExit(
                        enter = slideInHorizontally(),
                        exit = slideOutHorizontally()
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "退会")
                }
                Button(
                    modifier = Modifier.animateEnterExit(
                        enter = expandHorizontally(),
                        exit = shrinkHorizontally()
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "退会")
                }
            }
        }
    }
}

// 一回だけ
/*
@Composable
private fun AnimationScreen(modifier: Modifier = Modifier) {
    var startTransition by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(true){
        startTransition = true
    }
    val transition = updateTransition(startTransition, label = null)
    val translationY = transition.animateFloat(
        label = "",
        transitionSpec = {
            tween(durationMillis = 3000)
        },
        targetValueByState = { startTransition ->
            if (startTransition) {
                400f
            } else {
                0f
            }
        }
    )

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.botti),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
        )
        Image(
            modifier = Modifier
                .width(150.dp)
                .padding(top = 40.dp, end = 20.dp)
                .graphicsLayer {
                    this.translationY = translationY.value
                },
            painter = painterResource(id = R.drawable.kao),
            contentDescription = null,
        )
    }
}

/*
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
 */