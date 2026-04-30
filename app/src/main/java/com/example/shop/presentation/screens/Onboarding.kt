package com.example.shop.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.R
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun OnboardingOne(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(29.dp))
        Text(
            "ДОБРО ПОЖАЛОВАТЬ",
            style = CustomTheme.typography.HeadingBold30,
            color = CustomTheme.colors.block,
            modifier= Modifier.width(267.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(122.dp))
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.one),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
fun OnboardingTwo(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(37.dp))

        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.two),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            "Начнем путешествие",
            style = CustomTheme.typography.HeadingRegular34,
            color = CustomTheme.colors.block,
            modifier= Modifier.width(315.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(13.dp))
        Text(
            "Умная, великолепная и модная коллекция Изучите сейчас",
            style = CustomTheme.typography.SubtitleRegular16,
            color = CustomTheme.colors.block,
            modifier= Modifier.width(315.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun OnboardingThree(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(37.dp))
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.three),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            "У вас есть сила, чтобы",
            style = CustomTheme.typography.HeadingRegular34,
            color = CustomTheme.colors.block,
            modifier= Modifier.width(315.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(13.dp))
        Text(
            "В вашей комнате много красивых и привлекательных растений",
            style = CustomTheme.typography.SubtitleRegular16,
            color = CustomTheme.colors.block,
            modifier= Modifier.width(315.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun OnboardingPrev() {
    CustomTheme {
        OnboardingOne()
    }
}
@Preview
@Composable
private fun OnboardingPrev2() {
    CustomTheme {
        OnboardingTwo()
    }
}

@Preview
@Composable
private fun OnboardingPrev3() {
    CustomTheme {
        OnboardingThree()
    }
}
