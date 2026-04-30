package com.example.shop.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shop.presentation.components.SecondaryButton
import com.example.shop.presentation.navigation.Home
import com.example.shop.presentation.theme.CustomTheme
import kotlinx.coroutines.delay

@Composable
fun Onboard(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(CustomTheme.colors.accent, CustomTheme.colors.disable)
                )
            )
    ) {
        val pagerState = rememberPagerState(pageCount = { 3 })
        HorizontalPager(
            state = pagerState
        ) { page ->
            when (page) {
                0 -> {
                    OnboardingOne()
                }

                1 -> {
                    OnboardingTwo()
                }

                2 -> {
                    OnboardingThree()
                }
            }
        }
        var text = "Начать"
        var spacer = 136
        if (pagerState.currentPage != 0) {
            text = "далее"
            spacer=95
        }

        Spacer(modifier= Modifier.weight(1f))
        PagerIndicator(3, pagerState.currentPage)
        Spacer(modifier = Modifier.height(spacer.dp))
        SecondaryButton(onClick = {navController.navigate(Home)}, text = text, enabled = true, modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp))
        Spacer(modifier = Modifier.height(36.dp))
    }
}

@Composable
fun PagerIndicator(pageCount: Int, currentPageIndex: Int, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pageCount) { iteration ->
                val color =
                    if (currentPageIndex == iteration) CustomTheme.colors.block else CustomTheme.colors.disable
                val width =
                    if (currentPageIndex == iteration) 43 else 28
                Box(
                    modifier = modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(color)
                        .width(width.dp)
                        .height(5.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}


@Preview
@Composable
private fun OnboardPrev() {
    CustomTheme {
       // Onboard()
    }
}