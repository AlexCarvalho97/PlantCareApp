package com.alexc.plantcareapp.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexc.plantcareapp.R
import com.alexc.plantcareapp.ui.theme.GrayColor
import com.alexc.plantcareapp.ui.theme.Green


@Composable
fun DailyTip(
    tip: String,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .background(
                GrayColor,
                RoundedCornerShape(
                    20.dp
                )
            )
            .padding(25.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.idea_icon),
            contentDescription = null,
            tint = Green,
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.width(20.dp))

        Column {
            Text(
                text = "Daily Tip",
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp
            )

            Text(
                text = tip,
                color = Green,
            )
        }

    }

}


