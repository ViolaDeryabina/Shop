package com.example.shop.presentation.screens


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.shop.presentation.components.BottomBar
import com.example.shop.presentation.components.Input
import com.example.shop.presentation.components.ProfileHelper
import com.example.shop.presentation.navigation.Catalog
import com.example.shop.presentation.navigation.Favorite
import com.example.shop.presentation.navigation.MyCart
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Создание экрана отображение профиля пользователя
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
data class DataProfile(
    val icon: Int,
    val title: String
)

@Composable
fun Profile(modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }


    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.fillMaxSize()) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(CustomTheme.colors.accent),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.home_1),
                        contentDescription = "",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(top = 49.dp, bottom = 96.dp),
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, top = 30.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Top,
                    ) {
                        Spacer(modifier = Modifier.height(30.dp))
                        Image(
                            bitmap = ImageBitmap.imageResource(R.drawable.profile_icon),
                            contentDescription = "",
                            modifier = Modifier.size(96.dp)
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Emmanuel Oyiboke",
                            style = CustomTheme.typography.BodyRegular20,
                            color = CustomTheme.colors.block
                        )
                        Spacer(modifier = Modifier.height(55.dp))

                        val list = listOf(
                            DataProfile(
                                icon = R.drawable.profile,
                                title = "Профиль"
                            ),
                            DataProfile(
                                icon = R.drawable.bag_2,
                                title = "Корзина"
                            ),
                            DataProfile(
                                icon = R.drawable.favorite,
                                title = "Избранное"
                            ), DataProfile(
                                icon = R.drawable.orders,
                                title = "Заказы"
                            ), DataProfile(
                                icon = R.drawable.notification,
                                title = "Уведомления"
                            ), DataProfile(
                                icon = R.drawable.settings,
                                title = "Настройки"
                            ),
                            DataProfile(
                                icon = R.drawable.logout,
                                title = "Выйти"
                            )
                        )
                        list.forEach { it ->
                            Row() {
                                if (it.title == "Выйти") {
                                    Column() {
                                        Image(
                                            bitmap = ImageBitmap.imageResource(R.drawable.vector_1791),
                                            contentDescription = "",
                                            contentScale = ContentScale.FillWidth,
                                            modifier = Modifier.fillMaxWidth(),
                                        )
                                        Spacer(modifier = Modifier.height(30.dp))
                                        Row() {
                                            ProfileHelper(icon=it.icon, title = it.title)
                                        }

                                    }

                                } else {
                                    ProfileHelper(icon=it.icon, title = it.title)
                                }
                            }
                            Spacer(modifier = Modifier.height(30.dp))
                        }
                    }
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 22.dp, start = 18.dp, top = 14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(CustomTheme.colors.block)
                            .size(44.dp), onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.clock_1),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.71.dp)
                        )
                    }
                    Text(
                        text = "Профиль",
                        style = CustomTheme.typography.BodyRegular16,
                        color = CustomTheme.colors.text
                    )

                    IconButton(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(CustomTheme.colors.accent)
                            .size(25.dp), onClick = {
                            Log.d(
                                "Favorite",
                                "Нажатие кнопки favorite для перехода на экран Catalog"
                            )
                            navController.navigate(Catalog)
                        }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.edit),
                            contentDescription = "",
                            tint = CustomTheme.colors.block,
                            modifier = Modifier
                                .size(15.dp)
                            //.offset(y = (2).dp)
                        )
                    }

                }
            },
            bottomBar = {
                BottomBar(
                    selectedInt = 0,
                    homeOnClick = { },
                    favoriteOnClick = {
                        Log.d("Home", "Нажатие на кнопку favorite для перехода на форму Favorite")
                        navController.navigate(Favorite)
                    },
                    notificationOnClick = { },
                    profileOnClick = { },
                    basketOnClick = { navController.navigate(MyCart) }
                )
            },
            containerColor = CustomTheme.colors.block
        ) { innerPadding ->
            Column(
                Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 20.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(49.dp))
                Image(
                    bitmap = ImageBitmap.imageResource(R.drawable.profile_icon),
                    contentDescription = "",
                    modifier = Modifier.size(96.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Emmanuel Oyiboke",
                    style = CustomTheme.typography.BodyRegular20,
                    color = CustomTheme.colors.text
                )
                Spacer(modifier = Modifier.height(35.dp))
                Box(
                    modifier = Modifier
                        .background(
                            CustomTheme.colors.background,
                            RoundedCornerShape(16.dp)
                        )
                        .fillMaxWidth()
                        .padding(8.dp)

                ) {
                    Text(
                        text = "Открыть",
                        style = CustomTheme.typography.BodyRegular20,
                        color = CustomTheme.colors.text,
                    )
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.bar_code),
                        contentDescription = "",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Spacer(modifier = Modifier.height(21.dp))
                Input(
                    modifier = Modifier.fillMaxWidth(),
                    value = firstName,
                    onValueChange = { firstName = it },
                    placeholder = {
                        Text(
                            text = "Emmanuel", style = CustomTheme.typography.BodyRegular14,
                            color = CustomTheme.colors.hint
                        )
                    },
                    text = "Имя"
                )
                Spacer(modifier = Modifier.height(17.dp))

                Input(
                    modifier = Modifier.fillMaxWidth(),
                    value = lastName,
                    onValueChange = { lastName = it },
                    placeholder = {
                        Text(
                            text = "Oyiboke", style = CustomTheme.typography.BodyRegular14,
                            color = CustomTheme.colors.hint
                        )
                    },
                    text = "Фамилия"
                )
                Spacer(modifier = Modifier.height(17.dp))

                Input(
                    modifier = Modifier.fillMaxWidth(),
                    value = address,
                    onValueChange = { address = it },
                    placeholder = {
                        Text(
                            text = "Nigeria", style = CustomTheme.typography.BodyRegular14,
                            color = CustomTheme.colors.hint
                        )
                    },
                    text = "Адрес"
                )
                Spacer(modifier = Modifier.height(17.dp))

                Input(
                    modifier = Modifier.fillMaxWidth(),
                    value = phone,
                    onValueChange = { phone = it },
                    placeholder = {
                        Text(
                            text = "+7 811-732-5298", style = CustomTheme.typography.BodyRegular14,
                            color = CustomTheme.colors.hint
                        )
                    },
                    text = "Телефон"
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProfilePrev() {
    CustomTheme {
        Profile()
    }
}