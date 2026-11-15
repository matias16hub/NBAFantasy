package com.example.nbafantasy.ui.pantallas

import android.app.DatePickerDialog
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.nbafantasy.data.EquiposData
import com.example.nbafantasy.model.Jugador
import com.example.nbafantasy.ui.componentes.CampoDesplegable
import java.util.Calendar
import kotlin.math.roundToInt

@Composable
fun PantallaCrearJugador(
    onGuardar: (Jugador) -> Unit,
    onCancelar: () -> Unit,
    modifier: Modifier = Modifier
) {
    var nombre by remember { mutableStateOf("") }
    var equipo by remember { mutableStateOf("") }
    var rival by remember { mutableStateOf("") }
    var puntos by remember { mutableStateOf(0f) }
    var fecha by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    val posicionesElegidas = remember {
        mutableStateListOf<String>()
    }

    val nombres = listOf(
        "Nikola Jokić",
        "Giannis Antetokounmpo",
        "Jayson Tatum"
    )

    val posiciones = listOf("PG", "SG", "SF", "PF", "C")

    val contexto = LocalContext.current

    fun guardarJugador() {
        if (
            nombre == "" ||
            equipo == "" ||
            rival == "" ||
            fecha == "" ||
            posicionesElegidas.isEmpty()
        ) {
            error = "Completa todos los campos."
        } else if (equipo == rival) {
            error = "El equipo y el rival no pueden ser iguales."
        } else {
            val nuevoJugador = Jugador(
                id = 0,
                nombre = nombre,
                equipo = equipo,
                posiciones = posicionesElegidas.toList(),
                puntos = puntos.roundToInt(),
                rival = rival,
                fecha = fecha
            )

            onGuardar(nuevoJugador)
        }
    }

    BackHandler {
        guardarJugador()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextButton(
            onClick = { guardarJugador() }
        ) {
            Text(text = "← Volver y guardar")
        }

        Text(text = "Crear jugador")

        CampoDesplegable(
            etiqueta = "Jugador",
            seleccionado = nombre,
            opciones = nombres,
            onSeleccionar = { nombre = it }
        )

        CampoDesplegable(
            etiqueta = "Equipo",
            seleccionado = equipo,
            opciones = EquiposData.equipos,
            onSeleccionar = { equipo = it }
        )

        Text(text = "Selecciona una o varias posiciones")

        posiciones.forEach { posicion ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = posicionesElegidas.contains(posicion),
                    onCheckedChange = { marcada ->
                        if (marcada) {
                            posicionesElegidas.add(posicion)
                        } else {
                            posicionesElegidas.remove(posicion)
                        }
                    }
                )

                Text(text = posicion)
            }
        }

        Text(text = "Puntos: " + puntos.roundToInt())

        Slider(
            value = puntos,
            onValueChange = { puntos = it },
            valueRange = 0f..100f,
            steps = 99
        )

        CampoDesplegable(
            etiqueta = "Rival",
            seleccionado = rival,
            opciones = EquiposData.equipos,
            onSeleccionar = { rival = it }
        )

        Button(
            onClick = {
                val calendario = Calendar.getInstance()

                val anio = calendario.get(Calendar.YEAR)
                val mes = calendario.get(Calendar.MONTH)
                val dia = calendario.get(Calendar.DAY_OF_MONTH)

                val selectorFecha = DatePickerDialog(
                    contexto,
                    { _, anioElegido, mesElegido, diaElegido ->
                        fecha = "$diaElegido/${mesElegido + 1}/$anioElegido"
                    },
                    anio,
                    mes,
                    dia
                )

                selectorFecha.show()
            }
        ) {
            Text(text = "Elegir fecha")
        }

        Text(text = "Fecha: " + fecha)

        if (error != "") {
            Text(text = error)
        }

        TextButton(onClick = onCancelar) {
            Text(text = "Cancelar sin guardar")
        }
    }
}