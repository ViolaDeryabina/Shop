package com.example.shop.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shop.R
import com.example.shop.presentation.components.Back
import com.example.shop.presentation.components.Search
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun Search(modifier: Modifier = Modifier, navController: NavController= rememberNavController()) {
    var search by rememberSaveable { mutableStateOf("") }
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Back(onClick = { navController.popBackStack()},color= CustomTheme.colors.block)
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Поиск",
                        style = CustomTheme.typography.HeadingSemiBold16,
                        color = CustomTheme.colors.text
                    )
                }
            }
        },
        containerColor = CustomTheme.colors.background
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {

            Spacer(modifier = Modifier.height(6.dp))
            Search(
                modifier = Modifier.fillMaxWidth(),
                value = search,
                onValueChange = { search = it },
                placeholder = {
                    Text(
                        text = "Поиск",
                        style = CustomTheme.typography.BodyRegular12,
                        color = CustomTheme.colors.hint
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.marker_2),
                        contentDescription = "",
                        tint = CustomTheme.colors.subTextDark,
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
            )
            val row = listOf(
                "New Shoes",
                "Nike Top Shoes",
                "Nike Air Force",
                "Shoes",
                "Snakers Nike Shoes",
                "Regular Shoes"
            )
            Spacer(modifier = Modifier.height(31.dp))
            row.forEach { it ->
                Row() {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.clock),
                        contentDescription = "",
                        tint = CustomTheme.colors.subTextDark,
                        modifier = Modifier
                            .size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = it,
                        style = CustomTheme.typography.BodyRegular14,
                        color = CustomTheme.colors.text
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
            }

        }
    }
}

@Preview
@Composable
private fun SearchPrev() {
    CustomTheme {
        Search()
    }
}