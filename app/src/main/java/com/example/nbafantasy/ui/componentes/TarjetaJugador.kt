package com.example.nbafantasy.ui.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.nbafantasy.model.Jugador

@Composable
fun TarjetaJugador(jugador: Jugador) {
    Card(
        modifier = Modifier.fillMaxWidth(),

        colors = CardDefaults.cardColors(
            containerColor = colorEquipo(jugador.equipo),
            contentColor = Color.Black
        )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FotoJugador(nombre = jugador.nombre)

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = jugador.nombre,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(text = jugador.equipo)

                val posicionesTexto =
                    jugador.posiciones.joinToString(", ")

                Text(text = "Posiciones: " + posicionesTexto)

                Text(text = "Contra: " + jugador.rival)

                Text(text = "Puntos: " + jugador.puntos)

                Text(text = jugador.fecha)
            }
        }
    }
}