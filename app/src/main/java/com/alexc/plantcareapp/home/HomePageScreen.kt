package com.alexc.plantcareapp.home

import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexc.plantcareapp.utils.DateUtils
import com.alexc.plantcareapp.R
import com.alexc.plantcareapp.models.Plant
import com.alexc.plantcareapp.models.plantsList
import com.alexc.plantcareapp.ui.theme.GrayColor
import com.alexc.plantcareapp.ui.theme.Green
import com.alexc.plantcareapp.ui.theme.QuickSand

@Composable
fun HomePageScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    LazyColumn(
        modifier = modifier.padding(horizontal = 25.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Header(
                "Anastasiya",
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            DailyTip(
                tip = "Coffee or tea can be used as plant food",
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            AddPlantButton(
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            MyPlants(
                plantsList,
                navController
            )
        }
    }
}
