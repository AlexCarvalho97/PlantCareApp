package com.alexc.plantcareapp.details

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexc.plantcareapp.R
import com.alexc.plantcareapp.models.Plant
import com.alexc.plantcareapp.ui.theme.GrayColor
import com.alexc.plantcareapp.ui.theme.LightTextColor

@Composable
fun PlantInfo(
    plant: Plant,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .background(
                GrayColor,
                RoundedCornerShape(20.dp)
            )
            .padding(20.dp)
    ){

        Text(
            text = "Information",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = plant.plantInfo.details,
            fontWeight = FontWeight.SemiBold,
            color = LightTextColor
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row {
            PlantAdditionalInfo(
                iconId = R.drawable.humidity,
                info = plant.plantInfo.watering,
                modifier = Modifier.weight(0.25f)
            )

            Spacer(modifier = Modifier.width(10.dp))

            PlantAdditionalInfo(
                iconId = R.drawable.ic_sunny,
                info = plant.plantInfo.lighting,
                modifier = Modifier.weight(0.25f)
            )

            Spacer(modifier = Modifier.width(10.dp))

            PlantAdditionalInfo(
                iconId = R.drawable.ic_rice_bowl,
                info = plant.plantInfo.fertilizer,
                modifier = Modifier.weight(0.25f)
            )

        }

    }
}


@Composable
fun PlantAdditionalInfo(
    @DrawableRes iconId: Int,
    info: String = "",
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = LightTextColor,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = info,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = LightTextColor
        )
    }
}

