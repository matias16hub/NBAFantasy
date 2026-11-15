package com.example.nbafantasy.navegacion

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object Lista : NavKey

@Serializable
data object CrearJugador : NavKey

@Serializable
data class DetalleJugador(val jugadorId: Int) : NavKey