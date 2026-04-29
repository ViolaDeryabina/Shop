package com.example.shop.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.shop.R

val type = FontFamily(
    Font(R.font.raleway, weight = FontWeight.Normal),
    Font(R.font.raleway_bold, weight = FontWeight.Bold),
    Font(R.font.raleway_medium, weight = FontWeight.Medium),
    Font(R.font.raleway_semibold, weight = FontWeight.SemiBold),
    Font(R.font.raleway_extrabold, weight = FontWeight.ExtraBold),
    )

@Immutable
data class CustomTypography(
    val HeadingRegular34: TextStyle =
        TextStyle(
            fontSize = 34.sp,
            lineHeight = 44.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.Normal
        ),
    val HeadingRegular32: TextStyle=
        TextStyle(
            fontSize = 32.sp,
            //lineHeight = 44.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.Normal
        ),

    val HeadingBold30: TextStyle =
        TextStyle(
            fontSize = 30.sp,
           // lineHeight = 44.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.Bold
        ),
    val HeadingRegular26: TextStyle=
        TextStyle(
            fontSize = 26.sp,
            //lineHeight = 44.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.Normal
        ),

    val HeadingRegular20: TextStyle =
        TextStyle(
            fontSize = 20.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.Normal
        ),
    val HeadingSemiBold16: TextStyle=
        TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.SemiBold
        ),


    val SubtitleRegular16: TextStyle =
        TextStyle(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.Normal
        ),
    val BodyRegular24: TextStyle=
        TextStyle(
            fontSize = 24.sp,
            //lineHeight = 44.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.Normal
        ),

    val BodyRegular20: TextStyle =
        TextStyle(
            fontSize = 20.sp,
            // lineHeight = 44.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.Normal
        ),
    val BodySemiBold18: TextStyle=
        TextStyle(
            fontSize = 18.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.SemiBold
        ),

    val BodyMedium16: TextStyle =
        TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.Medium
        ),
    val BodyRegular16: TextStyle=
        TextStyle(
            fontSize = 16.sp,
            //lineHeight = 20.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.SemiBold
        ),


    val BodyMedium14: TextStyle=
        TextStyle(
            fontSize = 14.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.Medium
        ),

    val BodyRegular14: TextStyle =
        TextStyle(
            fontSize = 14.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.Normal
        ),
    val BodyRegular12: TextStyle=
        TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.sp,
            fontWeight = FontWeight.Normal
        ),
)

val LocalCustomTypography = staticCompositionLocalOf {
    CustomTypography()
}