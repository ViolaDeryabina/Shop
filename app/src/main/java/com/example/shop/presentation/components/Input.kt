package com.example.shop.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.presentation.theme.CustomTheme

//Назначение: Создание компонента ввода информации
//Автор: Дерябина В.Н.
//Дата: 30.04.2026
@Composable
fun Input(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    isLabel: Boolean = true,
    text: String = "Ваше имя",
    placeholder: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    Log.i("Input","Создание компонента ввода информации")

    Column() {
        if(isLabel){
            Text(
                text = text,
                style = CustomTheme.typography.BodyMedium16,
                color = CustomTheme.colors.text
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
        OutlinedTextField(
            modifier = modifier.height(48.dp),
            value = value,
            onValueChange = onValueChange,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = CustomTheme.colors.text,
                focusedContainerColor = CustomTheme.colors.background,
                unfocusedContainerColor = CustomTheme.colors.background,
                unfocusedTextColor = CustomTheme.colors.hint,
                disabledContainerColor = CustomTheme.colors.background,
                disabledTextColor = CustomTheme.colors.hint,
                focusedBorderColor = CustomTheme.colors.background,
                unfocusedBorderColor = CustomTheme.colors.background,
                disabledBorderColor = CustomTheme.colors.background,
            ),
            placeholder =placeholder,
            shape = RoundedCornerShape(14.dp),
            trailingIcon = trailingIcon,
            visualTransformation =visualTransformation,
            keyboardOptions = keyboardOptions
        )
    }

}

@Preview
@Composable
private fun RegisterAccountPrev() {
    CustomTheme {
        Input(value = "xxxxxxxx", onValueChange = {})
    }

}