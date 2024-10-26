// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.textfield

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import dev.tunnicliff.ui.component.text.TextVariant
import dev.tunnicliff.ui.component.text.color
import dev.tunnicliff.ui.theme.internal.disabled

enum class TextFieldVariant {
    PRIMARY,
    SECONDARY,
    SURFACE,
    SURFACE_VARIANT,
    TERTIARY
}

@Composable
internal fun TextFieldVariant.textFieldColors(): TextFieldColors = TextFieldDefaults.colors(
    disabledContainerColor = disabledContainerColor(),
    disabledLabelColor = disabledContentColor(),
    disabledTextColor = disabledContentColor(),
    disabledTrailingIconColor = disabledContentColor(),

    focusedContainerColor = containerColor(),
    focusedLabelColor = contentColor(),
    focusedTextColor = contentColor(),
    focusedTrailingIconColor = contentColor(),

    unfocusedContainerColor = containerColor(),
    unfocusedLabelColor = contentColor(),
    unfocusedTextColor = contentColor(),
    unfocusedTrailingIconColor = contentColor(),
)

internal fun TextFieldVariant.textVariant(): TextVariant =
    when (this) {
        TextFieldVariant.PRIMARY -> TextVariant.ON_PRIMARY
        TextFieldVariant.SECONDARY -> TextVariant.ON_SECONDARY
        TextFieldVariant.SURFACE -> TextVariant.ON_SURFACE
        TextFieldVariant.SURFACE_VARIANT -> TextVariant.ON_SURFACE_VARIANT
        TextFieldVariant.TERTIARY -> TextVariant.ON_TERTIARY
    }

@Composable
internal fun TextFieldVariant.textColor(enabled: Boolean): Color =
    if (enabled) contentColor() else disabledContentColor()

@Composable
internal fun TextFieldVariant.textStyle(enabled: Boolean): TextStyle =
    LocalTextStyle.current.copy(color = textColor(enabled = enabled))


@Composable
private fun TextFieldVariant.containerColor(): Color = when (this) {
    TextFieldVariant.PRIMARY -> MaterialTheme.colorScheme.primary
    TextFieldVariant.SECONDARY -> MaterialTheme.colorScheme.secondary
    TextFieldVariant.SURFACE -> MaterialTheme.colorScheme.surface
    TextFieldVariant.SURFACE_VARIANT -> MaterialTheme.colorScheme.surfaceVariant
    TextFieldVariant.TERTIARY -> MaterialTheme.colorScheme.tertiary
}

@Composable
private fun TextFieldVariant.contentColor(): Color = textVariant().color()

@Composable
private fun TextFieldVariant.disabledContainerColor(): Color =
    containerColor().disabled()

@Composable
private fun disabledContentColor(): Color =
    MaterialTheme.colorScheme.onSurface.disabled()