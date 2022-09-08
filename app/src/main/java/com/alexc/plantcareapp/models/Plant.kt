package com.alexc.plantcareapp.models

import androidx.annotation.DrawableRes
import com.alexc.plantcareapp.R

data class Plant(
    val name: String,
    @DrawableRes val imageId: Int,
    val scientificName: String,
    val plantDiagnostic: PlantDiagnostic,
    val plantInfo: PlantInfo
)


data class PlantDiagnostic(
    val wateringLevel: Float,
    val wateringInfo: String,
    val lightingLevel: Float,
    val lightingInfo: String,
)

data class PlantInfo(
    val details: String,
    val watering: String,
    val lighting: String, val fertilizer: String
)


val plantsList = listOf(
    Plant(
        name = "Linda",
        imageId = R.drawable.aloe_vera,
        scientificName = "Aloe vera",
        plantDiagnostic = PlantDiagnostic(0.7f, "need more water", 0.5f, "add more light"),
        plantInfo = PlantInfo(
            "The aloe vera is an attractive succulent plant that is a great indoor companion.",
            "every 2 weeks",
            "everyday",
            "monthly"
        )
    ),

    Plant(
        name = "Josh",
        imageId = R.drawable.succulent,
        scientificName = "Succulent",
        plantDiagnostic = PlantDiagnostic(0.4f, "need more water", 0.5f, "add more light"),
        plantInfo = PlantInfo(
            "Succulents are trendy plants, exotically shaped and easy to care for",
            "1 per week",
            "everyday",
            "Spring"
        )
    )
)