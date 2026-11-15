package com.example.nbafantasy.ui.componentes

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp

fun colorEquipo(equipo: String): Color {
    return when (equipo) {
        "Atlanta Hawks" -> lerp(Color.White, Color.Red, 0.20f)
        "Boston Celtics" -> lerp(Color.White, Color.Green, 0.20f)
        "Brooklyn Nets" -> Color.LightGray
        "Charlotte Hornets" -> lerp(Color.White, Color.Cyan, 0.20f)
        "Chicago Bulls" -> lerp(Color.White, Color.Red, 0.30f)
        "Cleveland Cavaliers" -> lerp(Color.White, Color.Magenta, 0.20f)
        "Dallas Mavericks" -> lerp(Color.White, Color.Blue, 0.15f)
        "Denver Nuggets" -> lerp(Color.White, Color.Yellow, 0.50f)
        "Detroit Pistons" -> lerp(Color.White, Color.Blue, 0.20f)
        "Golden State Warriors" -> lerp(Color.White, Color.Yellow, 0.70f)
        "Houston Rockets" -> lerp(Color.White, Color.Red, 0.40f)
        "Indiana Pacers" -> lerp(Color.White, Color.Yellow, 0.30f)
        "Los Angeles Clippers" -> lerp(Color.White, Color.Gray, 0.20f)
        "Los Angeles Lakers" -> lerp(Color.White, Color.Magenta, 0.30f)
        "Memphis Grizzlies" -> lerp(Color.White, Color.Blue, 0.25f)
        "Miami Heat" -> lerp(Color.White, Color.Red, 0.25f)
        "Milwaukee Bucks" -> lerp(Color.White, Color.Green, 0.35f)
        "Minnesota Timberwolves" -> lerp(Color.White, Color.Cyan, 0.30f)
        "New Orleans Pelicans" -> lerp(Color.White, Color.Gray, 0.30f)
        "New York Knicks" -> lerp(Color.Yellow, Color.Red, 0.25f)
        "Oklahoma City Thunder" -> lerp(Color.White, Color.Cyan, 0.40f)
        "Orlando Magic" -> lerp(Color.White, Color.Blue, 0.30f)
        "Philadelphia 76ers" -> lerp(Color.White, Color.Blue, 0.35f)
        "Phoenix Suns" -> lerp(Color.White, Color.Magenta, 0.35f)
        "Portland Trail Blazers" -> lerp(Color.White, Color.Red, 0.15f)
        "Sacramento Kings" -> lerp(Color.White, Color.Magenta, 0.40f)
        "San Antonio Spurs" -> lerp(Color.White, Color.Gray, 0.50f)
        "Toronto Raptors" -> lerp(Color.White, Color.Red, 0.35f)
        "Utah Jazz" -> lerp(Color.White, Color.Green, 0.15f)
        "Washington Wizards" -> lerp(Color.White, Color.Blue, 0.10f)
        else -> Color.White
    }
}