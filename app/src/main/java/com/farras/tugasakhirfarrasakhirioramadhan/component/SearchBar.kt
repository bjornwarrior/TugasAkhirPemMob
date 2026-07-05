package com.farras.tugasakhirfarrasakhirioramadhan.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource // Menggunakan painterResource bawaan
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        leadingIcon = {
            // Menggunakan ikon galeri bawaan android core agar aman dari error unresolved
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_search),
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = { Text("Cari menu kuliner...") },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}