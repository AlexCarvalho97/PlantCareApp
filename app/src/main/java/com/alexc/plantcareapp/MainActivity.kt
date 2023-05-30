package com.alexc.plantcareapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alexc.plantcareapp.bottombar.BottomBar
import com.alexc.plantcareapp.details.PlantDetailScreen
import com.alexc.plantcareapp.home.HomePageScreen
import com.alexc.plantcareapp.ui.theme.PlantCareAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlantCareAppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val bottomBarEnabled = rememberSaveable {
                    mutableStateOf(true)
                }

                bottomBarEnabled.value = when (navBackStackEntry?.destination?.route) {
                    "plant_detail_page/{plantName}" -> false
                    else -> true
                }


                Scaffold(
                    bottomBar = {
                        if (bottomBarEnabled.value) {
                            BottomBar()
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = "home_page",
                        modifier = Modifier.padding(paddingValues)
                    ) {

                        composable("home_page") {
                            HomePageScreen(
                                navController = navController
                            )
                        }

                        composable("plant_detail_page/{plantName}",
                            arguments = listOf(
                                navArgument("plantName") {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            val plantName = remember {
                                it.arguments?.getString("plantName")
                            }

                            PlantDetailScreen(
                                plantName ?: "",
                                navController
                            )
                        }
                    }

                }
            }
        }
    }
}
