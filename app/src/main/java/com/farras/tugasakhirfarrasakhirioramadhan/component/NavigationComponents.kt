package com.farras.tugasakhirfarrasakhirioramadhan.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.farras.tugasakhirfarrasakhirioramadhan.R
import com.farras.tugasakhirfarrasakhirioramadhan.navigation.Screen

@Composable
fun BottomNavigation(navController: NavController, currentRoute: String) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.surfaceVariant) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text(stringResource(R.string.bottom_navigation_home)) },
            selected = currentRoute == Screen.Home.route,
            onClick = { if (currentRoute != Screen.Home.route) navController.navigate(Screen.Home.route) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
            label = { Text(stringResource(R.string.bottom_navigation_profile)) },
            selected = currentRoute == Screen.Profile.route,
            onClick = { if (currentRoute != Screen.Profile.route) navController.navigate(Screen.Profile.route) }
        )
    }
}

@Composable
fun SampingNavigationRail(navController: NavController, currentRoute: String, modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                label = { Text(stringResource(R.string.bottom_navigation_home)) },
                selected = currentRoute == Screen.Home.route,
                onClick = { if (currentRoute != Screen.Home.route) navController.navigate(Screen.Home.route) }
            )
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(
                icon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
                label = { Text(stringResource(R.string.bottom_navigation_profile)) },
                selected = currentRoute == Screen.Profile.route,
                onClick = { if (currentRoute != Screen.Profile.route) navController.navigate(Screen.Profile.route) }
            )
        }
    }
}