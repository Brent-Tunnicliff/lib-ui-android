// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.picker

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.tunnicliff.ui.component.textfield.TextFieldVariant
import dev.tunnicliff.ui.component.textfield.textFieldColors
import dev.tunnicliff.ui.theme.internal.disabled

enum class PickerVariant {
    PRIMARY,
    SECONDARY,
    SURFACE,
    SURFACE_VARIANT,
    TERTIARY
}

@Composable
internal fun PickerVariant.textFieldColors(): TextFieldColors =
    textFieldVariant().textFieldColors()

@Composable
internal fun PickerVariant.menuItemBackgroundColor(): Color = when (this) {
    PickerVariant.PRIMARY -> MaterialTheme.colorScheme.primaryContainer
    PickerVariant.SECONDARY -> MaterialTheme.colorScheme.secondaryContainer
    PickerVariant.SURFACE -> MaterialTheme.colorScheme.surfaceVariant
    PickerVariant.SURFACE_VARIANT -> MaterialTheme.colorScheme.surface
    PickerVariant.TERTIARY -> MaterialTheme.colorScheme.tertiaryContainer
}

@Composable
internal fun PickerVariant.menuItemColors(): MenuItemColors = MenuDefaults.itemColors(
    textColor = menuItemContentColor(),
    disabledTextColor = MaterialTheme.colorScheme.onSurface.disabled()
)

@Composable
private fun PickerVariant.menuItemContentColor(): Color = when (this) {
    PickerVariant.PRIMARY -> MaterialTheme.colorScheme.onPrimaryContainer
    PickerVariant.SECONDARY -> MaterialTheme.colorScheme.onSecondaryContainer
    PickerVariant.SURFACE -> MaterialTheme.colorScheme.onSurfaceVariant
    PickerVariant.SURFACE_VARIANT -> MaterialTheme.colorScheme.onSurface
    PickerVariant.TERTIARY -> MaterialTheme.colorScheme.onTertiaryContainer
}

private fun PickerVariant.textFieldVariant(): TextFieldVariant = when (this) {
    PickerVariant.PRIMARY -> TextFieldVariant.PRIMARY
    PickerVariant.SECONDARY -> TextFieldVariant.SECONDARY
    PickerVariant.SURFACE -> TextFieldVariant.SURFACE
    PickerVariant.SURFACE_VARIANT -> TextFieldVariant.SURFACE_VARIANT
    PickerVariant.TERTIARY -> TextFieldVariant.TERTIARY
}