package com.example.shop.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.shop.R
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun DialogCheckout(modifier: Modifier = Modifier, onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardColors(
                containerColor = CustomTheme.colors.block,
                contentColor = CustomTheme.colors.text,
                disabledContainerColor = CustomTheme.colors.block,
                disabledContentColor = CustomTheme.colors.text,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(134.dp)
                        .background(Color(0xFFDFEFFF), CircleShape)
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.image_50),
                        contentDescription = "",
                        modifier = Modifier.size(86.dp)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Вы успешно\n оформили заказ",
                    style = CustomTheme.typography.BodyRegular20,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(30.dp))
                PrimaryButton(
                    onClick = {onDismissRequest()},
                    text = "Вернуться к покупкам",
                    enabled = true,
                    modifier = Modifier.width(234.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun DialogCheckoutPrev() {
    CustomTheme {
        DialogCheckout(onDismissRequest = {})
    }
}