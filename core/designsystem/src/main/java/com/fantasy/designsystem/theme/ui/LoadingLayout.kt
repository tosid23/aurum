package com.fantasy.designsystem.theme.ui

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.fantasy.designsystem.R

@Preview
@Composable
fun DotLoadingLayout() {
    val rawComposition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.dot_loading))
    LottieAnimation(
        composition = rawComposition,
        modifier = Modifier
            .height(150.dp),
        contentScale = ContentScale.Fit,
        iterations = 100
    )
}