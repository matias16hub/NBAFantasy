package com.example.nbafantasy.data

import com.example.nbafantasy.model.Jugador

object JugadoresData {
    val jugadores = listOf(
        Jugador(
            id = 1,
            nombre = "Nikola Jokić",
            equipo = "Denver Nuggets",
            posiciones = listOf("C"),
            puntos = 30,
            rival = "Boston Celtics",
            fecha = "10/11/2026"
        ),
        Jugador(
            id = 2,
            nombre = "Giannis Antetokounmpo",
            equipo = "Milwaukee Bucks",
            posiciones = listOf("PF", "C"),
            puntos = 34,
            rival = "Miami Heat",
            fecha = "11/11/2026"
        ),
        Jugador(
            id = 3,
            nombre = "Jayson Tatum",
            equipo = "Boston Celtics",
            posiciones = listOf("SF", "PF"),
            puntos = 27,
            rival = "Chicago Bulls",
            fecha = "12/11/2026"
        ),
        Jugador(
            id = 4,
            nombre = "Nikola Jokić",
            equipo = "Denver Nuggets",
            posiciones = listOf("C"),
            puntos = 24,
            rival = "Phoenix Suns",
            fecha = "13/11/2026"
        )
    )
}