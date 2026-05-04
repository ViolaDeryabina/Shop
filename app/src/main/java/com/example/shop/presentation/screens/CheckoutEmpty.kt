package com.example.shop.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shop.R
import com.example.shop.presentation.components.Back
import com.example.shop.presentation.components.PrimaryButton
import com.example.shop.presentation.theme.CustomTheme
import kotlinx.coroutines.flow.Flow


data class Info(
    var image: Int,
    var info: String,
    var placeholder: String
)

data class Bottom(
    var sum: Float,
    val title: String
)

@Composable
fun CheckoutEmpty(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Back(onClick = { navController.popBackStack() }, color = CustomTheme.colors.block)
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Корзина",
                        style = CustomTheme.typography.HeadingSemiBold16,
                        color = CustomTheme.colors.text
                    )
                }
            }
        },
        bottomBar = {
            Column(modifier= Modifier.padding(horizontal = 20.dp)) {
                val listBottom = listOf<Bottom>(
                    Bottom(
                        sum = 753.95f,
                        title = "Сумма"
                    ),
                    Bottom(
                        sum = 60.20f,
                        title = "Доставка"
                    ),
                    Bottom(
                        sum = 814.15f,
                        title = "Итого"
                    )
                )
                listBottom.forEach { it ->
                    if(it.title=="Итого"){
                        Spacer(modifier = Modifier.height(23.dp))
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = it.title,
                            style = CustomTheme.typography.BodyRegular16,
                            color = if (it.title == "Итого") CustomTheme.colors.text else CustomTheme.colors.hint
                        )
                        Text(
                            text = "₽${it.sum}",
                            style = CustomTheme.typography.BodyRegular16,
                            color = if (it.title == "Итого") CustomTheme.colors.accent else CustomTheme.colors.text
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                }
                Spacer(modifier = Modifier.height(23.dp))
                PrimaryButton(onClick = {}, text = "Подтвердить", enabled = true)
                Spacer(modifier = Modifier.height(31.dp))

            }
        },
        containerColor = CustomTheme.colors.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        CustomTheme.colors.block,
                        RoundedCornerShape(16.dp)
                    )
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Text(
                    text = "Контактная информация",
                    style = CustomTheme.typography.BodyMedium14,
                    color = CustomTheme.colors.text
                )

                val list = listOf<Info>(
                    Info(R.drawable.email, "Email", "*******@****.***"),
                    Info(R.drawable.call, "Телефон", "**-***-***-****")
                )
                list.forEach { it ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row() {
                            Box(
                                modifier = Modifier
                                    .background(
                                        CustomTheme.colors.background,
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .size(40.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(it.image),
                                    contentDescription = "",
                                    tint = CustomTheme.colors.text,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column() {
                                Text(
                                    text = it.placeholder,
                                    style = CustomTheme.typography.BodyMedium14,
                                    color = CustomTheme.colors.text
                                )
                                Text(
                                    text = it.info,
                                    style = CustomTheme.typography.BodyRegular12,
                                    color = CustomTheme.colors.hint
                                )
                            }
                        }
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.edit),
                            contentDescription = "",
                            tint = CustomTheme.colors.hint,
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Адрес",
                    style = CustomTheme.typography.BodyMedium14,
                    color = CustomTheme.colors.text
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "1082 Аэропорт, Нигерии",
                        style = CustomTheme.typography.BodyRegular12,
                        color = CustomTheme.colors.hint
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.edit),
                        contentDescription = "",
                        tint = CustomTheme.colors.hint,
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.carta),
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 20.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Посмотреть на карте",
                            style = CustomTheme.typography.HeadingRegular20,
                            color = CustomTheme.colors.block
                        )
                        Box(
                            modifier = Modifier
                                .background(CustomTheme.colors.accent, CircleShape)
                                .size(
                                    36.dp
                                ), contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.marker),
                                contentDescription = "",
                                tint = CustomTheme.colors.block,
                                modifier = Modifier
                                    .size(25.dp)
                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Способ оплаты",
                    style = CustomTheme.typography.BodyMedium14,
                    color = CustomTheme.colors.text
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row() {
                        Box(
                            modifier = Modifier
                                .background(
                                    CustomTheme.colors.background,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .size(40.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                bitmap = ImageBitmap.imageResource(R.drawable.image_55),
                                contentDescription = "",
                                modifier = Modifier.size(32.dp, 22.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Добавить",
                                style = CustomTheme.typography.BodyRegular14,
                                color = CustomTheme.colors.text
                            )
                            Text(
                                text = "**** *****",
                                style = CustomTheme.typography.BodyRegular12,
                                color = CustomTheme.colors.hint
                            )
                        }
                    }
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.arrow_down),
                        contentDescription = "",
                        tint = CustomTheme.colors.hint,
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CheckoutEmptyPrev() {
    CustomTheme {
        CheckoutEmpty()
    }
}