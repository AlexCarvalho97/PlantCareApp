package com.alexc.plantcareapp.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alexc.plantcareapp.models.Plant
import com.alexc.plantcareapp.ui.theme.GrayColor

@Composable
fun PlantThumb(
    plant: Plant,
    modifier: Modifier
){
    Box(
        modifier = modifier
            .background(
                GrayColor,
                RoundedCornerShape(20.dp)
            )
            .height(170.dp)
    ) {
        Image(
            painter = painterResource(id = plant.imageId),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-20).dp)
        )
    }
}
