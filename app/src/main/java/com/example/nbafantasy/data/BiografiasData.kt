package com.example.nbafantasy.data

object BiografiasData {

    fun obtenerBiografia(nombre: String): String {
        return when (nombre) {
            "Nikola Jokić", "Nikola Jokic" ->
                "Nikola Jokić es un jugador serbio que juega como pívot. " +
                        "Antes de llegar a la NBA jugó en el equipo serbio Mega. " +
                        "Denver lo seleccionó en el puesto 41 del Draft de 2014, " +
                        "durante la segunda ronda.\n\n" +
                        "Su juego combina la anotación cerca de la canasta con " +
                        "los rebotes y los pases a sus compañeros. Aunque ocupa " +
                        "una posición interior, también participa en la organización " +
                        "del ataque y puede acumular muchas asistencias.\n\n" +
                        "En 2023 ayudó a Denver a conseguir el primer campeonato " +
                        "de su historia. Los Nuggets derrotaron a Miami en la final " +
                        "y Jokić recibió el premio al jugador más valioso de la serie. " +
                        "En el tercer partido de aquellas finales consiguió " +
                        "32 puntos, 21 rebotes y 10 asistencias."

            "Giannis Antetokounmpo" ->
                "Giannis Antetokounmpo es un jugador griego que llegó " +
                        "a la NBA después de jugar en el Filathlitikos de Grecia. " +
                        "Milwaukee lo seleccionó en el puesto 15 del Draft de 2013. " +
                        "Con el paso de las temporadas se convirtió en una pieza " +
                        "fundamental de los Bucks.\n\n" +
                        "Puede contribuir en distintas partes del juego: anotar, " +
                        "capturar rebotes, repartir asistencias y defender. " +
                        "Su capacidad para participar en varias estadísticas " +
                        "hace que resulte interesante para un equipo de fantasy.\n\n" +
                        "En 2021 ganó el campeonato con Milwaukee y fue elegido " +
                        "jugador más valioso de las finales. En el sexto partido " +
                        "contra Phoenix anotó 50 puntos y ayudó a cerrar la serie. " +
                        "También ha representado a Grecia en competiciones " +
                        "internacionales, incluidos los Juegos Olímpicos de París 2024."

            "Jayson Tatum" ->
                "Jayson Tatum es un jugador estadounidense que se formó " +
                        "en la Universidad de Duke antes de llegar a la NBA. " +
                        "Boston lo seleccionó en el tercer puesto del Draft de 2017. " +
                        "En su primera temporada fue incluido en el mejor quinteto " +
                        "de jugadores debutantes de la liga.\n\n" +
                        "Durante sus primeras siete temporadas ayudó a Boston " +
                        "a alcanzar cinco finales de la Conferencia Este. " +
                        "También participó en las finales de la NBA de 2022 y 2024, " +
                        "y recibió varias selecciones para el partido All-Star " +
                        "y los mejores quintetos de la competición.\n\n" +
                        "En 2024 consiguió el campeonato con los Celtics tras " +
                        "derrotar a Dallas. En el quinto partido, que decidió " +
                        "la serie, anotó 31 puntos y repartió 11 asistencias. " +
                        "Con aquella victoria se convirtió en otro de los antiguos " +
                        "jugadores de Duke que han ganado un título de la NBA."

            else -> "No hay biografía disponible para este jugador."
        }
    }
}