package com.example.nbafantasy.ui.pantallas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.nbafantasy.data.EquiposData
import com.example.nbafantasy.model.Jugador
import com.example.nbafantasy.ui.componentes.TarjetaJugador

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaJugadores(
    jugadores: List<Jugador>,
    modoBorrado: Boolean,
    seleccionados: List<Int>,
    onSeleccionar: (Int) -> Unit,
    onAbrir: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var busqueda by remember { mutableStateOf("") }
    var abierta by remember { mutableStateOf(false) }
    var equipoSeleccionado by remember { mutableStateOf("") }

    val foco = LocalFocusManager.current

    val equiposEncontrados = EquiposData.equipos.filter { equipo ->
        equipo.startsWith(busqueda, ignoreCase = true)
    }

    val jugadoresMostrados = jugadores.filter { jugador ->
        equipoSeleccionado == "" ||
                jugador.equipo == equipoSeleccionado
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SearchBar(
            modifier = Modifier.fillMaxWidth(),

            inputField = {
                SearchBarDefaults.InputField(
                    query = busqueda,

                    onQueryChange = {
                        busqueda = it
                        equipoSeleccionado = ""
                    },

                    onSearch = {
                        abierta = false
                        foco.clearFocus()
                    },

                    expanded = abierta,

                    onExpandedChange = {
                        abierta = it
                    },

                    placeholder = {
                        Text(text = "Buscar equipo")
                    },

                    trailingIcon = {
                        TextButton(
                            onClick = {
                                busqueda = ""
                                equipoSeleccionado = ""
                            }
                        ) {
                            Text(text = "Limpiar")
                        }
                    }
                )
            },

            expanded = abierta,

            onExpandedChange = {
                abierta = it
            }
        ) {
            Column(
                modifier = Modifier.verticalScroll(
                    rememberScrollState()
                )
            ) {
                if (equiposEncontrados.isEmpty()) {
                    Text(
                        text = "No hay equipos con ese comienzo.",
                        modifier = Modifier.padding(16.dp)
                    )
                }

                equiposEncontrados.forEach { equipo ->
                    TextButton(
                        modifier = Modifier.fillMaxWidth(),

                        onClick = {
                            busqueda = equipo
                            equipoSeleccionado = equipo
                            abierta = false
                            foco.clearFocus()
                        }
                    ) {
                        Text(text = equipo)
                    }
                }
            }
        }

        if (!abierta) {
            if (modoBorrado) {
                Text(
                    text = "Seleccionados: " + seleccionados.size,
                    modifier = Modifier.padding(16.dp)
                )
            }

            if (jugadoresMostrados.isEmpty()) {
                Text(
                    text = "No hay registros de este equipo.",
                    modifier = Modifier.padding(16.dp)
                )
            }

            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 220.dp
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = jugadoresMostrados,
                    key = { jugador -> jugador.id }
                ) { jugador ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (modoBorrado) {
                            Checkbox(
                                checked = seleccionados.contains(
                                    jugador.id
                                ),
                                onCheckedChange = {
                                    onSeleccionar(jugador.id)
                                }
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clickable(
                                    enabled = !modoBorrado,
                                    onClick = {
                                        onAbrir(jugador.id)
                                    }
                                )
                        ) {
                            TarjetaJugador(jugador = jugador)
                        }
                    }
                }
            }
        }
    }
}