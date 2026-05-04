package com.example.shop.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.shop.R
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun CustomDialog(
    onDismissRequest: () -> Unit, text: String,
    popup: Boolean = false
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(196.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardColors(
                containerColor = CustomTheme.colors.block,
                contentColor = CustomTheme.colors.text,
                disabledContainerColor = CustomTheme.colors.block,
                disabledContentColor = CustomTheme.colors.text,
            )
        ) {
            if (popup) {
                Column(
                    modifier = Modifier
                        .fillMaxSize().padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(44.dp)
                            .background(CustomTheme.colors.accent, CircleShape)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.email_1),
                            contentDescription = "",
                            tint = CustomTheme.colors.block,
                            modifier = Modifier
                                .clickable(onClick = { })
                                .offset(y = (-2).dp)
                        )
                    }
                    Text(
                        text = "Проверьте Ваш Email",
                        style = CustomTheme.typography.HeadingSemiBold16
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Мы отправили код восстановления пароля на вашу электронную почту.",
                        style = CustomTheme.typography.BodyRegular16,
                        color = CustomTheme.colors.subTextDark,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = text,
                        modifier = Modifier.padding(16.dp),
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        PrimaryButton(onClick = onDismissRequest, text = "Закрыть", enabled = true)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Prev() {
    CustomTheme {
        CustomDialog(onDismissRequest = {}, popup = true, text = "")
    }
}