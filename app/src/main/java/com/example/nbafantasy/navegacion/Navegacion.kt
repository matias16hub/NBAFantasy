package com.example.nbafantasy.navegacion

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.nbafantasy.data.JugadoresData
import com.example.nbafantasy.ui.pantallas.PantallaCrearJugador
import com.example.nbafantasy.ui.pantallas.PantallaDetalleJugador
import com.example.nbafantasy.ui.pantallas.PantallaJugadores

@Composable
fun Navegacion() {
    val pila = rememberNavBackStack(Lista)

    val jugadores = remember {
        JugadoresData.jugadores.toMutableStateList()
    }

    var modoBorrado by remember { mutableStateOf(false) }
    var mostrarDialogo by remember { mutableStateOf(false) }

    val seleccionados = remember {
        mutableStateListOf<Int>()
    }

    NavDisplay(
        backStack = pila,

        onBack = {
            if (pila.size > 1) {
                pila.removeAt(pila.lastIndex)
            }
        },

        entryProvider = entryProvider {
            entry<Lista> {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),

                    floatingActionButton = {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(
                                12.dp
                            )
                        ) {
                            ExtendedFloatingActionButton(
                                modifier = Modifier.semantics {
                                    if (modoBorrado) {
                                        disabled()
                                    }
                                },

                                containerColor = if (modoBorrado) {
                                    Color.LightGray
                                } else {
                                    MaterialTheme.colorScheme.primaryContainer
                                },

                                contentColor = if (modoBorrado) {
                                    Color.DarkGray
                                } else {
                                    MaterialTheme.colorScheme.onPrimaryContainer
                                },

                                onClick = {
                                    if (!modoBorrado) {
                                        pila.add(CrearJugador)
                                    }
                                }
                            ) {
                                Text(text = "Añadir")
                            }

                            ExtendedFloatingActionButton(
                                onClick = {
                                    if (modoBorrado) {
                                        mostrarDialogo = true
                                    } else {
                                        modoBorrado = true
                                    }
                                }
                            ) {
                                if (modoBorrado) {
                                    Text(text = "Confirmar borrado")
                                } else {
                                    Text(text = "Borrar")
                                }
                            }

                            if (modoBorrado) {
                                TextButton(
                                    onClick = {
                                        seleccionados.clear()
                                        modoBorrado = false
                                    }
                                ) {
                                    Text(text = "Cancelar borrado")
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    PantallaJugadores(
                        jugadores = jugadores,
                        modoBorrado = modoBorrado,
                        seleccionados = seleccionados,

                        onSeleccionar = { id ->
                            if (seleccionados.contains(id)) {
                                seleccionados.remove(id)
                            } else {
                                seleccionados.add(id)
                            }
                        },

                        onAbrir = { id ->
                            pila.add(
                                DetalleJugador(jugadorId = id)
                            )
                        },

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }

            entry<CrearJugador> {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    PantallaCrearJugador(
                        onGuardar = { jugador ->
                            var nuevoId = 1

                            for (registro in jugadores) {
                                if (registro.id >= nuevoId) {
                                    nuevoId = registro.id + 1
                                }
                            }

                            val jugadorConId = jugador.copy(
                                id = nuevoId
                            )

                            jugadores.add(jugadorConId)

                            if (pila.size > 1) {
                                pila.removeAt(pila.lastIndex)
                            }
                        },

                        onCancelar = {
                            if (pila.size > 1) {
                                pila.removeAt(pila.lastIndex)
                            }
                        },

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }

            entry<DetalleJugador> { destino ->
                val jugador = jugadores.find { registro ->
                    registro.id == destino.jugadorId
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    if (jugador != null) {
                        PantallaDetalleJugador(
                            jugador = jugador,
                            jugadores = jugadores,

                            onVolver = {
                                if (pila.size > 1) {
                                    pila.removeAt(pila.lastIndex)
                                }
                            },

                            modifier = Modifier.padding(innerPadding)
                        )
                    } else {
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .padding(16.dp)
                        ) {
                            Text(text = "No se encuentra el registro.")

                            TextButton(
                                onClick = {
                                    if (pila.size > 1) {
                                        pila.removeAt(pila.lastIndex)
                                    }
                                }
                            ) {
                                Text(text = "Volver")
                            }
                        }
                    }
                }
            }
        }
    )

    if (mostrarDialogo) {
        AlertDialog(
            onDismissRequest = {
                mostrarDialogo = false
            },

            title = {
                Text(text = "Borrar registros")
            },

            text = {
                Text(
                    text = "¿Quieres borrar los registros seleccionados? " +
                            "Cantidad: " + seleccionados.size
                )
            },

            confirmButton = {
                TextButton(
                    onClick = {
                        jugadores.removeAll { jugador ->
                            seleccionados.contains(jugador.id)
                        }

                        seleccionados.clear()
                        modoBorrado = false
                        mostrarDialogo = false
                    }
                ) {
                    Text(text = "OK")
                }
            },

            dismissButton = {
                TextButton(
                    onClick = {
                        mostrarDialogo = false
                    }
                ) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}