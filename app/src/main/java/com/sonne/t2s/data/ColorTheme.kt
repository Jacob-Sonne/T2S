package com.sonne.t2s.data

// A color Int consists of 4 hex values 0xARGB all going from 0 to 255 (00 - FF)
// A: Alpha
// R: Red
// G: Green
// B: Blue
// Color Int example: 0xFF6200EE

data class ColorTheme(
    val primary: Int,
    val primaryVariant: Int,
    val secondary: Int,
    val secondaryVariant: Int,

    val background: Int,
    val surface: Int,
    val error: Int,
    val warning: Int,
    val success: Int,

    val onPrimary: Int,
    val onSecondary: Int,
    val onBackground: Int,
    val onSurface: Int,
    val onError: Int,
    val onWarning: Int,
    val onSuccess: Int,
)

val LightColors = ColorTheme(
    primary = 0xFF6200EE.toInt(),
    primaryVariant = TODO(),
    secondary = TODO(),
    secondaryVariant = TODO(),
    background = TODO(),
    surface = TODO(),
    error = TODO(),
    warning = TODO(),
    success = TODO(),
    onPrimary = TODO(),
    onSecondary = TODO(),
    onBackground = TODO(),
    onSurface = TODO(),
    onError = TODO(),
    onWarning = TODO(),
    onSuccess = TODO()
)

val DarkColors = ColorTheme(
    primary = TODO(),
    primaryVariant = TODO(),
    secondary = TODO(),
    secondaryVariant = TODO(),
    background = TODO(),
    surface = TODO(),
    error = TODO(),
    warning = TODO(),
    success = TODO(),
    onPrimary = TODO(),
    onSecondary = TODO(),
    onBackground = TODO(),
    onSurface = TODO(),
    onError = TODO(),
    onWarning = TODO(),
    onSuccess = TODO()
)
