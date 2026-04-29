package com.example.shop.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Red = Color(0xFFF87265)
val Accent = Color(0xFF48B2E7)
val Disable = Color(0xFF2B6B8B)

val SubTextLight = Color(0xFFD8D8D8)
val Background = Color(0xFFF7F7F9)
val Block = Color(0xFFFFFFFF)

val Text = Color(0xFF2B2B2B)
val Hint = Color(0xFF6A6A6A)
val SubTextDark = Color(0xFF707B81)

@Immutable
data class CustomColors(
    val red: Color = Red,
    val accent: Color = Accent,
    val disable: Color = Disable,
    val subTextLight: Color = SubTextLight,
    val background: Color = Background,
    val block: Color = Block,
    val text: Color = Text,
    val hint: Color = Hint,
    val subTextDark: Color = SubTextDark
)

val LocalCustomColors = staticCompositionLocalOf{
    CustomColors()
}