package com.farras.tugasakhirfarrasakhirioramadhan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.farras.tugasakhirfarrasakhirioramadhan.component.BottomNavigation
import com.farras.tugasakhirfarrasakhirioramadhan.component.SampingNavigationRail
import com.farras.tugasakhirfarrasakhirioramadhan.navigation.Screen
import com.farras.tugasakhirfarrasakhirioramadhan.screen.DetailScreen
import com.farras.tugasakhirfarrasakhirioramadhan.screen.MainScreen
import com.farras.tugasakhirfarrasakhirioramadhan.screen.ProfileScreen
import com.farras.tugasakhirfarrasakhirioramadhan.ui.theme.TugasAkhirFarrasAkhirioRamadhanTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasAkhirFarrasAkhirioRamadhanTheme {
                val windowSizeClass = calculateWindowSizeClass(this)
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) {
                    composable(Screen.Home.route) {
                        val widthClass = windowSizeClass.widthSizeClass
                        if (widthClass == WindowWidthSizeClass.Compact) {
                            AppPortrait(navController)
                        } else {
                            AppLandscape(navController)
                        }
                    }
                    composable(Screen.Profile.route) {
                        ProfileScreen(navController)
                    }
                    composable(
                        route = Screen.Detail.route,
                        arguments = listOf(navArgument("namaKuliner") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val namaKuliner = backStackEntry.arguments?.getString("namaKuliner") ?: ""
                        DetailScreen(namaKuliner = namaKuliner, navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun AppPortrait(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigation(navController, currentRoute = Screen.Home.route) }
    ) { padding ->
        Surface(
            modifier = Modifier.fillMaxSize().padding(padding),
            color = Color(0xFFF5F0EE)
        ) {
            MainScreen(navController)
        }
    }
}

@Composable
fun AppLandscape(navController: NavController) {
    Surface(color = Color(0xFFF5F0EE)) {
        Row(modifier = Modifier.fillMaxSize()) {
            SampingNavigationRail(navController, currentRoute = Screen.Home.route)
            MainScreen(navController, modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp", name = "Interactive App Preview - Portrait")
@Composable
fun FullAppPortraitPreview() {
    TugasAkhirFarrasAkhirioRamadhanTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                AppPortrait(navController)
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController)
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("namaKuliner") { type = NavType.StringType })
            ) { backStackEntry ->
                val namaKuliner = backStackEntry.arguments?.getString("namaKuliner") ?: "Kuliner Pilihan"
                DetailScreen(namaKuliner = namaKuliner, navController = navController)
            }
        }
    }
}

@Preview(showBackground = true, device = "spec:width=891dp,height=411dp,orientation=landscape", name = "Interactive App Preview - Landscape")
@Composable
fun FullAppLandscapePreview() {
    TugasAkhirFarrasAkhirioRamadhanTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                AppLandscape(navController)
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController)
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("namaKuliner") { type = NavType.StringType })
            ) { backStackEntry ->
                val namaKuliner = backStackEntry.arguments?.getString("namaKuliner") ?: "Kuliner Pilihan"
                DetailScreen(namaKuliner = namaKuliner, navController = navController)
            }
        }
    }
}