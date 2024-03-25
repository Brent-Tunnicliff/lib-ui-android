package dev.tunnicliff.ui.component.picker

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.tunnicliff.ui.theme.internal.disabled

enum class PickerVariant {
    PRIMARY,
    SECONDARY,
    SURFACE,
    SURFACE_VARIANT,
    TERTIARY
}

@Composable
internal fun PickerVariant.textFieldColors(): TextFieldColors = TextFieldDefaults.colors(
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
private fun PickerVariant.containerColor(): Color = when (this) {
    PickerVariant.PRIMARY -> MaterialTheme.colorScheme.primary
    PickerVariant.SECONDARY -> MaterialTheme.colorScheme.secondary
    PickerVariant.SURFACE -> MaterialTheme.colorScheme.surface
    PickerVariant.SURFACE_VARIANT -> MaterialTheme.colorScheme.surfaceVariant
    PickerVariant.TERTIARY -> MaterialTheme.colorScheme.tertiary
}

@Composable
private fun PickerVariant.contentColor(): Color = when (this) {
    PickerVariant.PRIMARY -> MaterialTheme.colorScheme.onPrimary
    PickerVariant.SECONDARY -> MaterialTheme.colorScheme.onSecondary
    PickerVariant.SURFACE -> MaterialTheme.colorScheme.onSurface
    PickerVariant.SURFACE_VARIANT -> MaterialTheme.colorScheme.onSurfaceVariant
    PickerVariant.TERTIARY -> MaterialTheme.colorScheme.onTertiary
}

@Composable
private fun PickerVariant.disabledContainerColor(): Color =
    containerColor().disabled()

@Composable
private fun disabledContentColor(): Color =
    MaterialTheme.colorScheme.onSurface.disabled()

@Composable
private fun PickerVariant.menuItemContentColor(): Color = when (this) {
    PickerVariant.PRIMARY -> MaterialTheme.colorScheme.onPrimaryContainer
    PickerVariant.SECONDARY -> MaterialTheme.colorScheme.onSecondaryContainer
    PickerVariant.SURFACE -> MaterialTheme.colorScheme.onSurfaceVariant
    PickerVariant.SURFACE_VARIANT -> MaterialTheme.colorScheme.onSurface
    PickerVariant.TERTIARY -> MaterialTheme.colorScheme.onTertiaryContainer
}