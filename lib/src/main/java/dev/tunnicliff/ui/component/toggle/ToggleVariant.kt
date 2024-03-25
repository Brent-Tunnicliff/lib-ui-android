package dev.tunnicliff.ui.component.toggle

import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.tunnicliff.ui.theme.internal.disabled

enum class ToggleVariant {
    PRIMARY,
    SECONDARY,
    TERTIARY
}

@Composable
internal fun ToggleVariant.checkboxColors(): CheckboxColors = CheckboxDefaults.colors(
    checkedColor = containerColor(),
    uncheckedColor = containerColor(),
    checkmarkColor = contentColor(),
    disabledCheckedColor = containerColor().disabled(),
    disabledUncheckedColor = containerColor().disabled(),
    disabledIndeterminateColor = contentColor().disabled()
)

@Composable
internal fun ToggleVariant.switchColors(): SwitchColors = SwitchDefaults.colors(
    checkedThumbColor = contentColor(),
    checkedTrackColor = containerColor(),
    checkedIconColor = containerColor(),

    disabledCheckedThumbColor = contentColor().disabled(),
    disabledCheckedTrackColor = containerColor().disabled(),
    disabledCheckedIconColor = containerColor().disabled(),

    uncheckedThumbColor = uncheckedContentColor(),
    uncheckedBorderColor = containerColor(),
    uncheckedIconColor = containerColor(),

    disabledUncheckedThumbColor = uncheckedContentColor().disabled(),
    disabledUncheckedBorderColor = containerColor().disabled(),
    disabledUncheckedIconColor = containerColor().disabled(),
)


@Composable
private fun ToggleVariant.containerColor(): Color = when (this) {
    ToggleVariant.PRIMARY -> MaterialTheme.colorScheme.primary
    ToggleVariant.SECONDARY -> MaterialTheme.colorScheme.secondary
    ToggleVariant.TERTIARY -> MaterialTheme.colorScheme.tertiary
}

@Composable
private fun ToggleVariant.uncheckedContainerColor(): Color = when (this) {
    ToggleVariant.PRIMARY -> MaterialTheme.colorScheme.primaryContainer
    ToggleVariant.SECONDARY -> MaterialTheme.colorScheme.secondaryContainer
    ToggleVariant.TERTIARY -> MaterialTheme.colorScheme.tertiaryContainer
}

@Composable
private fun ToggleVariant.contentColor(): Color = when (this) {
    ToggleVariant.PRIMARY -> MaterialTheme.colorScheme.onPrimary
    ToggleVariant.SECONDARY -> MaterialTheme.colorScheme.onSecondary
    ToggleVariant.TERTIARY -> MaterialTheme.colorScheme.onTertiary
}

@Composable
private fun ToggleVariant.uncheckedContentColor(): Color = when (this) {
    ToggleVariant.PRIMARY -> MaterialTheme.colorScheme.onPrimaryContainer
    ToggleVariant.SECONDARY -> MaterialTheme.colorScheme.onSecondaryContainer
    ToggleVariant.TERTIARY -> MaterialTheme.colorScheme.onTertiaryContainer
}

