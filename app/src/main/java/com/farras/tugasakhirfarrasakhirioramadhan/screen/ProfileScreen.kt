package com.farras.tugasakhirfarrasakhirioramadhan.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.farras.tugasakhirfarrasakhirioramadhan.component.BottomNavigation
import com.farras.tugasakhirfarrasakhirioramadhan.R

@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigation(navController, currentRoute = "profilescreen") }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Gunakan salah satu gambar bulat kulinermu sebagai avatar sementara
            Image(
                painter = painterResource(R.drawable.farras_akhirio_ramadhan),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )

            Text(
                text = stringResource(R.string.profile),
                modifier = Modifier.paddingFromBaseline(top = 32.dp, bottom = 8.dp),
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = "Farras Akhirio Ramadhan\nSoftware Developer Kuliner Nusantara",
                modifier = Modifier.padding(24.dp),
                overflow = TextOverflow.Clip,
                maxLines = 5,
                color = Color(0xFF2E7D32), // Hijau khas kuliner segar
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace,
                letterSpacing = 2.sp,
                textAlign = TextAlign.Center,
            )

            Button(
                onClick = { navController.navigate("homescreen") }
            ) {
                Text("Kembali ke Beranda")
            }
        }
    }
}