package com.example.nbafantasy.ui.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nbafantasy.data.BiografiasData
import com.example.nbafantasy.model.Jugador
import com.example.nbafantasy.ui.componentes.FotoJugador

@Composable
fun PantallaDetalleJugador(
    jugador: Jugador,
    jugadores: List<Jugador>,
    onVolver: () -> Unit,
    modifier: Modifier = Modifier
) {
    var partidos = 0
    var puntosTotales = 0

    for (registro in jugadores) {
        if (registro.nombre == jugador.nombre) {
            partidos = partidos + 1
            puntosTotales = puntosTotales + registro.puntos
        }
    }

    var media = 0f

    if (partidos > 0) {
        media = puntosTotales.toFloat() / partidos
    }

    val biografia = BiografiasData.obtenerBiografia(
        jugador.nombre
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextButton(onClick = onVolver) {
            Text(text = "← Volver")
        }

        FotoJugador(
            nombre = jugador.nombre,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = jugador.nombre,
            style = MaterialTheme.typography.headlineSmall
        )

        Text(text = "Equipo: " + jugador.equipo)

        val posicionesTexto =
            jugador.posiciones.joinToString(", ")

        Text(text = "Posiciones: " + posicionesTexto)

        Text(text = "Partidos registrados: " + partidos)

        Text(text = "Puntos totales: " + puntosTotales)

        Text(text = "Media de puntos: " + media)

        Text(
            text = "Partido seleccionado",
            style = MaterialTheme.typography.titleMedium
        )

        Text(text = "Rival: " + jugador.rival)

        Text(text = "Fecha: " + jugador.fecha)

        Text(text = "Puntos en este partido: " + jugador.puntos)

        Text(
            text = "Biografía",
            style = MaterialTheme.typography.titleMedium
        )

        Text(text = biografia)
    }
}