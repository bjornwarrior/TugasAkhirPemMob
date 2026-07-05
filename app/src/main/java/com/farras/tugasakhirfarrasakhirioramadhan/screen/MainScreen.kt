package com.farras.tugasakhirfarrasakhirioramadhan.screen


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.farras.tugasakhirfarrasakhirioramadhan.component.KategoriBulat
import com.farras.tugasakhirfarrasakhirioramadhan.component.RekomendasiCard
import com.farras.tugasakhirfarrasakhirioramadhan.component.SearchBar
import com.farras.tugasakhirfarrasakhirioramadhan.data.KulinerItem
import com.farras.tugasakhirfarrasakhirioramadhan.R

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    // State Hoisting: Mengontrol state pencarian teks di tingkat Screen
    var searchQuery by remember { mutableStateOf("") }

    // Mock data kuliner
    val kategoriList = remember {
        listOf(
            KulinerItem(R.drawable.sate_ayam, "Sate Ayam"),
            KulinerItem(R.drawable.nasi_goreng, "Nasi Goreng"),
            KulinerItem(R.drawable.bakso, "Bakso"),
            KulinerItem(R.drawable.rendang, "Rendang"),
            KulinerItem(R.drawable.gado_gado, "Gado-Gado")
        )
    }

    // PERUBAHAN: Mengarahkan resource dummy ke drawable rekomendasi asli milikmu
    val rekomendasiList = remember {
        listOf(
            KulinerItem(R.drawable.kuliner_nusantara, "Kuliner Nusantara"),
            KulinerItem(R.drawable.jajanan_pasar, "Jajanan Pasar"),
            KulinerItem(R.drawable.minuman_segar, "Minuman Segar"),
            KulinerItem(R.drawable.street_food, "Street Food")
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Komponen SearchBar
        SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Section Kategori Bulat
        Text(
            text = "Eksplor Rasa Kuliner",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 8.dp),
            color = Color.Black
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(kategoriList) { item ->
                KategoriBulat(item = item)
            }
        }

        // Section Rekomendasi Card
        Text(
            text = "Koleksi Rekomendasi",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 8.dp),
            color = Color.Black
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(rekomendasiList) { item ->
                RekomendasiCard(item = item)
            }
        }
    }
}