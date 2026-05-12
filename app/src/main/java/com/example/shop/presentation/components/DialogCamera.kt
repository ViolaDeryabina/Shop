package com.example.shop.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.shop.presentation.logInfo
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun DialogCamera(
    onDismissRequest: () -> Unit = {},
    onClickCamera: () -> Unit = {},
    onClickGallery: () -> Unit = {},
    onClickCand: () -> Unit = {},
) {
    logInfo("DialogCamera", "Создание компонента", "Диалоговое окно")

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardColors(
                containerColor = CustomTheme.colors.block,
                contentColor = CustomTheme.colors.text,
                disabledContainerColor = CustomTheme.colors.block,
                disabledContentColor = CustomTheme.colors.text,
            )
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Row() {
                    SecondaryButton(
                        onClick = { onClickCamera() },
                        text = "Камера",
                        enabled = true,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    SecondaryButton(
                        onClick = { onClickGallery() },
                        text = "Галерея",
                        enabled = true,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    SecondaryButton(
                        onClick = { onClickCand() },
                        text = "Кандинский",
                        enabled = true,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                PrimaryButton(onClick = { onDismissRequest() }, text = "Отмена", enabled = true)
            }
        }
    }
}

@Preview
@Composable
private fun DialogCameraPrev() {
    CustomTheme {
        DialogCamera()
    }
}