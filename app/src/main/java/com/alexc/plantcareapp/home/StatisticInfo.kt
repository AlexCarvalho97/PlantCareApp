package com.alexc.plantcareapp.home

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexc.plantcareapp.ui.theme.Green


@Composable
fun StatisticInfo(
    @DrawableRes iconId: Int,
    progress: Float,
    info: String = "",
    modifier: Modifier = Modifier.height(25.dp)
) {

    var _progress by remember { mutableStateOf(0f) }
    val progressAnimation by animateFloatAsState(
        targetValue = _progress,
        animationSpec = tween(durationMillis = 1500)
    )

    LaunchedEffect(key1 = progress) {
        _progress = progress
    }

    Row(modifier = modifier) {
        Box(
            modifier = Modifier
                .shadow(3.dp, CircleShape, clip = true)
                .background(Color.White, CircleShape)
                .align(Alignment.CenterVertically)
        ) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = null,
                tint = Green,
                modifier = Modifier.padding(5.dp)
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 10.dp)
        ) {
            LinearProgressIndicator(
                progress = progressAnimation,
                color = Green,
                modifier = Modifier
                    .clip(CircleShape)
            )

            if (info.isNotEmpty()) {
                Text(
                    text = info,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                )
            }
        }
    }
}
