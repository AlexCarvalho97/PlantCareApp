package com.alexc.plantcareapp.bottombar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alexc.plantcareapp.R
import com.alexc.plantcareapp.ui.theme.Green


sealed class BottomBarItem(
    val title: String,
    @DrawableRes val iconId: Int
) {
    object MyPlants : BottomBarItem(
        title = "My Plants",
        iconId = R.drawable.user
    )

    object Shop : BottomBarItem(
        title = "Shop",
        iconId = R.drawable.shopping_cart
    )

    object Settings : BottomBarItem(
        title = "Settings",
        iconId = R.drawable.menu
    )
}


@Composable
fun BottomBar() {
    val screens = listOf(
        BottomBarItem.MyPlants,
        BottomBarItem.Shop,
        BottomBarItem.Settings
    )

    var selectedTitle by remember { mutableStateOf(BottomBarItem.MyPlants.title) }

    BottomNavigation(
        backgroundColor = Color.White
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                selectedTitle = selectedTitle
            ){ selection ->
                selectedTitle = selection
            }
        }
    }

}


@Composable
fun RowScope.AddItem(
    screen: BottomBarItem,
    selectedTitle: String,
    onSelectedChange: (String) -> Unit
) {
    BottomNavigationItem(
        label = {
            Text(
                text = screen.title
            )
        },
        selected = screen.title == selectedTitle,
        onClick = {
            onSelectedChange(screen.title)
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.iconId),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        },
        selectedContentColor = Green,
        unselectedContentColor = Color.LightGray
    )
}