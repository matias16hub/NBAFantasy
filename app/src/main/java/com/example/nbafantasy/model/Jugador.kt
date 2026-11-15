package com.example.nbafantasy.model

data class Jugador(
    val id: Int,
    val nombre: String,
    val equipo: String,
    val posiciones: List<String>,
    val puntos: Int,
    val rival: String,
    val fecha: String
)