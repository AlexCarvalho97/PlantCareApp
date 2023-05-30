package com.alexc.plantcareapp.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexc.plantcareapp.R
import com.alexc.plantcareapp.home.StatisticInfo
import com.alexc.plantcareapp.models.Plant
import com.alexc.plantcareapp.ui.theme.GrayColor
import com.alexc.plantcareapp.ui.theme.LightTextColor


@Composable
fun PlantDiagnostics(
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
    ) {
        Row {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = plant.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Text(
                    text = plant.scientificName,
                    fontWeight = FontWeight.Bold,
                    color = LightTextColor,
                    fontSize = 13.sp
                )
            }

            Text(
                text = "latest diagnostic",
                fontWeight = FontWeight.Bold,
                color = LightTextColor,
                fontSize = 13.sp,
                modifier = Modifier.padding(top = 5.dp)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            StatisticInfo(
                iconId = R.drawable.humidity,
                progress = plant.plantDiagnostic.wateringLevel,
                info = plant.plantDiagnostic.wateringInfo,
                modifier = Modifier
                    .weight(1f)
                    .height(25.dp)
            )

            Spacer(modifier = Modifier.width(15.dp))

            StatisticInfo(
                iconId = R.drawable.ic_sunny,
                progress = plant.plantDiagnostic.lightingLevel,
                info = plant.plantDiagnostic.lightingInfo,
                modifier = Modifier
                    .weight(1f)
                    .height(25.dp)
            )
        }


    }
}