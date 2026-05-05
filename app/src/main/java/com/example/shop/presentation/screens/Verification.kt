package com.example.shop.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shop.presentation.components.Input
import com.example.shop.presentation.theme.CustomTheme
import kotlinx.coroutines.delay
import java.sql.Time
import java.util.concurrent.TimeUnit

//Назначение: Создание экрана подтверждения OTP
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun Verification(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    var index1 by remember { mutableStateOf("") }
    var index2 by remember { mutableStateOf("") }
    var index3 by remember { mutableStateOf("") }
    var index4 by remember { mutableStateOf("") }
    var index5 by remember { mutableStateOf("") }
    var index6 by remember { mutableStateOf("") }

    var time by remember { mutableStateOf(60) }

    LaunchedEffect(time) {
        if (time > 0) {
            delay(1000L)
            time--
        }
    }

    val minutes = time / 60
    val seconds = time % 60
    val timeString = String.format("%02d:%02d", minutes, seconds)

    Scaffold(
        topBar = {
            BackBar(onClick = { navController.popBackStack() })
        },
        containerColor = CustomTheme.colors.block
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "OTP проверка",
                style = CustomTheme.typography.HeadingRegular32,
                color = CustomTheme.colors.text
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Пожалуйста, проверьте свою\n электронную почту, чтобы увидеть код подтверждения",
                style = CustomTheme.typography.BodyRegular16,
                color = CustomTheme.colors.subTextDark,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "OTP Код",
                    style = CustomTheme.typography.BodyRegular16,
                    color = CustomTheme.colors.text,
                    textAlign = TextAlign.Start
                )
            }
            val list = mutableListOf(index1, index2, index3, index4, index5, index6)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(6) { item ->
                    Input(
                        value = list[item],
                        onValueChange = { newValue ->
                            if (newValue.length <= 1) {
                                list[item] = newValue
                            }
                        },
                        modifier = Modifier.size(width = 46.dp, height = 99.dp),
                        isLabel = false
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = timeString,
                    style = CustomTheme.typography.BodyRegular16,
                    color = CustomTheme.colors.text,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}

@Preview
@Composable
private fun VerificationPrev() {
    CustomTheme {
        Verification()
    }
}