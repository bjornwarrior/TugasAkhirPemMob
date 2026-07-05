package com.farras.tugasakhirfarrasakhirioramadhan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.farras.tugasakhirfarrasakhirioramadhan.screen.MainScreen // BARIS IMPORT YANG PERLU DITAMBAHKAN
import com.farras.tugasakhirfarrasakhirioramadhan.ui.theme.TugasAkhirFarrasAkhirioRamadhanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasAkhirFarrasAkhirioRamadhanTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF5F0EE)
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, showSystemUi = true)
@Composable
fun AppPreview() {
    TugasAkhirFarrasAkhirioRamadhanTheme {
        MainScreen()
    }
}