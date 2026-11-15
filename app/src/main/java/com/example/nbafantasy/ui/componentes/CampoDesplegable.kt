package com.example.nbafantasy.ui.componentes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun CampoDesplegable(
    etiqueta: String,
    seleccionado: String,
    opciones: List<String>,
    onSeleccionar: (String) -> Unit
) {
    var abierto by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = seleccionado,
            onValueChange = {},
            label = { Text(text = etiqueta) },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                TextButton(
                    onClick = { abierto = true }
                ) {
                    Text(text = "Elegir")
                }
            }
        )

        DropdownMenu(
            expanded = abierto,
            onDismissRequest = { abierto = false }
        ) {
            opciones.forEach { opcion ->
                DropdownMenuItem(
                    text = { Text(text = opcion) },
                    onClick = {
                        onSeleccionar(opcion)
                        abierto = false
                    }
                )
            }
        }
    }
}