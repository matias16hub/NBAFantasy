package com.example.nbafantasy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.nbafantasy.navegacion.Navegacion
import com.example.nbafantasy.ui.theme.NBAFantasyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NBAFantasyTheme {
                Navegacion()
            }
        }
    }
}