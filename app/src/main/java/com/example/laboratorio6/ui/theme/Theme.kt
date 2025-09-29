package com.example.laboratorio6.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val light = lightColorScheme()
private val dark = darkColorScheme()

@Composable
fun Laboratorio6Theme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) dark else light,
        typography = androidx.compose.material3.Typography(),
        content = content
    )
}

