package com.alexc.plantcareapp.details

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.alexc.plantcareapp.ui.theme.Green
import com.alexc.plantcareapp.ui.theme.QuickSand


@Composable
fun PlantDiagnoseButton(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.FavoriteBorder,
            contentDescription = null,
            tint = Green,
            modifier = Modifier.padding(start = 20.dp)
        )

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(backgroundColor = Green),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .weight(1f)
                .padding(start = 20.dp)
        ) {
            Text(
                text = "Diagnose",
                fontFamily = QuickSand,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }

    }
}