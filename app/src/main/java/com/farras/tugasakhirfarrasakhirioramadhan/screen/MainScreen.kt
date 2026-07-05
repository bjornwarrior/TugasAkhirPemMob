package com.farras.tugasakhirfarrasakhirioramadhan.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.farras.tugasakhirfarrasakhirioramadhan.R
import com.farras.tugasakhirfarrasakhirioramadhan.component.HomeSection
import com.farras.tugasakhirfarrasakhirioramadhan.component.KategoriBulat
import com.farras.tugasakhirfarrasakhirioramadhan.component.RekomendasiCard
import com.farras.tugasakhirfarrasakhirioramadhan.component.SearchBar
import com.farras.tugasakhirfarrasakhirioramadhan.data.KulinerItem
import com.farras.tugasakhirfarrasakhirioramadhan.navigation.Screen

@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        Spacer(Modifier.height(16.dp))

        SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow(navController)
        }

        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid(navController)
        }

        Spacer(Modifier.height(16.dp))
    }
}

// GANTI BAGIAN COMSAPABLE INI SAJA DI FILE MAINSCREEN.KT
@Composable
fun AlignYourBodyRow(navController: NavController, modifier: Modifier = Modifier) {
    val kategoriList = remember {
        listOf(
            KulinerItem(R.drawable.sate_ayam, "Sate Ayam"),
            KulinerItem(R.drawable.nasi_goreng, "Nasi Goreng"),
            KulinerItem(R.drawable.bakso, "Bakso"),
            KulinerItem(R.drawable.rendang, "Rendang"),
            KulinerItem(R.drawable.gado_gado, "Gado-Gado")
        )
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(kategoriList) { item ->
            Box(modifier = Modifier.clickable {
                navController.navigate(Screen.Detail.createRoute(item.title))
            }) {
                KategoriBulat(item = item)
            }
        }
    }
}
// GANTI BAGIAN COMSAPABLE INI SAJA DI FILE MAINSCREEN.KT
@Composable
fun FavoriteCollectionsGrid(navController: NavController, modifier: Modifier = Modifier) {
    val rekomendasiList = remember {
        listOf(
            KulinerItem(R.drawable.kuliner_nusantara, "Kuliner Nusantara"),
            KulinerItem(R.drawable.jajanan_pasar, "Jajanan Pasar"),
            KulinerItem(R.drawable.minuman_segar, "Minuman Segar"),
            KulinerItem(R.drawable.street_food, "Street Food")
        )
    }

    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(rekomendasiList) { item ->
            RekomendasiCard(
                item = item,
                modifier = Modifier
                    .height(80.dp)
                    .clickable {
                        navController.navigate(Screen.Detail.createRoute(item.title))
                    }
            )
        }
    }
}