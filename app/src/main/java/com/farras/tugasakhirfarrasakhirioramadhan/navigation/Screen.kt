package com.farras.tugasakhirfarrasakhirioramadhan.navigation

sealed class Screen(val route: String) {
    object Home : Screen("homescreen")
    object Profile : Screen("profilescreen")
    object Detail : Screen("detailscreen/{namaKuliner}") {
        fun createRoute(namaKuliner: String) = "detailscreen/$namaKuliner"
    }
}