package com.alexc.plantcareapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexc.plantcareapp.R
import com.alexc.plantcareapp.utils.DateUtils


@Composable
fun Header(
    name: String,
    modifier: Modifier
) {
    Row(modifier = modifier) {
        Column(
            modifier = Modifier.weight(3f)
        ) {
            Text(
                text = "Hello, $name!",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = DateUtils.getCurrentDateString(),
                color = Color.LightGray
            )
        }

        Image(
            painter = painterResource(id = R.drawable.profile_thumb),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}
