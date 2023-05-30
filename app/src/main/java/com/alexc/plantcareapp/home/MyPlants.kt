package com.alexc.plantcareapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexc.plantcareapp.R
import com.alexc.plantcareapp.models.Plant
import com.alexc.plantcareapp.ui.theme.GrayColor

@Composable
fun MyPlants(
    plantList: List<Plant>,
    navController: NavController
) {
    Column {
        Text(
            text = "My plants",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        plantList.forEach { plant ->
            PlantCard(
                plant,
                Modifier.fillMaxWidth()
            ) {
                navController.navigate(
                    "plant_detail_page/$it"
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }

}

@Composable
fun PlantCard(
    plant: Plant,
    modifier: Modifier,
    onClick: (String) -> Unit
) {

    Row(
        modifier = modifier
            .background(
                GrayColor,
                RoundedCornerShape(20.dp)
            )
            .height(height = 170.dp)
            .padding(end = 20.dp)
            .clickable {
                onClick(plant.name)
            }
    ) {

        Image(
            painter = painterResource(id = plant.imageId),
            contentDescription = null,
            modifier = Modifier
                .offset(y = (-20).dp)
                .weight(1f)
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f)
        ) {

            Text(
                text = plant.name,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = plant.scientificName,
                color = Color.LightGray,
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            StatisticInfo(
                R.drawable.humidity,
                plant.plantDiagnostic.wateringLevel
            )

            Spacer(modifier = Modifier.height(10.dp))

            StatisticInfo(
                R.drawable.ic_sunny,
                plant.plantDiagnostic.lightingLevel
            )
        }
    }
}

