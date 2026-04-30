package com.example.shop.presentation.components


import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.R
import com.example.shop.presentation.theme.CustomTheme

@Composable
fun Search(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    OutlinedTextField(
        modifier = modifier.height(52.dp).shadow(elevation = 11.dp),
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.marker_1),
                contentDescription = "",
                tint = CustomTheme.colors.hint,)
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = CustomTheme.colors.text,
            focusedContainerColor = CustomTheme.colors.block,
            unfocusedContainerColor = CustomTheme.colors.block,
            unfocusedTextColor = CustomTheme.colors.hint,
            disabledContainerColor = CustomTheme.colors.block,
            disabledTextColor = CustomTheme.colors.hint,
            focusedBorderColor = CustomTheme.colors.block,
            unfocusedBorderColor = CustomTheme.colors.block,
            disabledBorderColor = CustomTheme.colors.block,
        ),
        placeholder = placeholder,
        shape = RoundedCornerShape(14.dp),
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions
    )
}

@Preview
@Composable
private fun SearchPrev() {
    CustomTheme {
        Search(value = "xxxxxxxx", onValueChange = {})
    }
}