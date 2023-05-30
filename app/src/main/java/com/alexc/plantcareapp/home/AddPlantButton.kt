package com.alexc.plantcareapp.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.alexc.plantcareapp.ui.theme.Green
import com.alexc.plantcareapp.ui.theme.QuickSand

@Composable
fun AddPlantButton(
    modifier: Modifier
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Green),
        shape = RoundedCornerShape(30.dp)
    ) {
        Text(
            text = "Add a plant",
            color = Color.White,
            fontFamily = QuickSand,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(5.dp)
        )
    }
}