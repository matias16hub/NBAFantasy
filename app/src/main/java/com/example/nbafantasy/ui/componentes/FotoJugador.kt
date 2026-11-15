package com.example.nbafantasy.ui.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nbafantasy.R

@Composable
fun FotoJugador(
    nombre: String,
    modifier: Modifier = Modifier
) {
    val imagen = when (nombre) {
        "Nikola Jokić", "Nikola Jokic" -> R.drawable.jokic
        "Giannis Antetokounmpo" -> R.drawable.giannis
        "Jayson Tatum" -> R.drawable.tatum
        else -> android.R.drawable.ic_menu_gallery
    }

    Image(
        painter = painterResource(id = imagen),
        contentDescription = "Foto de " + nombre,
        contentScale = ContentScale.Fit,
        modifier = modifier.size(100.dp)
    )
}