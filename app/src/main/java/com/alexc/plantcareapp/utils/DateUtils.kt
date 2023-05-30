package com.alexc.plantcareapp.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    fun getCurrentDateString(): String =
        SimpleDateFormat("MMMM d, yyyy", Locale.US).format(Date())
}