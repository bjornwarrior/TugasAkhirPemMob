package com.farras.tugasakhirfarrasakhirioramadhan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.farras.tugasakhirfarrasakhirioramadhan.screen.MainScreen
import com.farras.tugasakhirfarrasakhirioramadhan.ui.theme.TugasAkhirFarrasAkhirioRamadhanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasAkhirFarrasAkhirioRamadhanTheme {
                Scaffold(
                    bottomBar = { BottomNavigation() }
                ) { paddingValues ->
                    Surface(
                        modifier = Modifier.fillMaxSize().padding(paddingValues),
                        color = Color(0xFFF5F0EE)
                    ) {
                        MainScreen()
                    }
                }
            }
        }
    }
}

@Composable
private fun BottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            label = { Text(stringResource(R.string.bottom_navigation_home)) },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) },
            label = { Text(stringResource(R.string.bottom_navigation_profile)) },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, showSystemUi = true)
@Composable
fun AppPreview() {
    TugasAkhirFarrasAkhirioRamadhanTheme {
        Scaffold(
            bottomBar = { BottomNavigation() }
        ) { padding ->
            MainScreen(Modifier.padding(padding))
        }
    }
}