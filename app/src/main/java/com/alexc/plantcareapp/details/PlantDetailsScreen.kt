package com.alexc.plantcareapp.details

import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexc.plantcareapp.R
import com.alexc.plantcareapp.home.StatisticInfo
import com.alexc.plantcareapp.models.Plant
import com.alexc.plantcareapp.models.PlantDiagnostic
import com.alexc.plantcareapp.models.plantsList
import com.alexc.plantcareapp.ui.theme.GrayColor
import com.alexc.plantcareapp.ui.theme.Green
import com.alexc.plantcareapp.ui.theme.LightTextColor
import com.alexc.plantcareapp.ui.theme.QuickSand


@Composable
fun PlantDetailScreen(
    plantName: String,
    navController: NavController
) {

    val plant = remember(plantName) {
        plantsList.find {
            it.name == plantName
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 25.dp)
            .padding(bottom = 25.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    navController.popBackStack()
                }
        )


        PlantThumb(
            plant!!,
            modifier = Modifier.fillMaxWidth()
        )

        PlantDiagnostics(
            plant,
            modifier = Modifier.fillMaxWidth()
        )

        PlantInfo(
            plant,
            modifier = Modifier.fillMaxWidth()
        )

        PlantDiagnoseButton(
            modifier = Modifier.fillMaxWidth()
        )
    }
}
