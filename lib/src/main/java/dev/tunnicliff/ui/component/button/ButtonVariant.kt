// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.button

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.tunnicliff.ui.theme.internal.disabled

enum class ButtonVariant {
    ERROR,
    PRIMARY,
    SECONDARY,
    TERTIARY
}

@Composable
internal fun ButtonVariant.filledButtonColors(): ButtonColors = ButtonDefaults.buttonColors(
    containerColor = contentColor(),
    disabledContainerColor = contentColor().disabled()
)

@Composable
internal fun ButtonVariant.filledTextColor(enabled: Boolean): Color =
    getTextColor(baseColor = onContentColor(), enabled = enabled)

@Composable
internal fun ButtonVariant.iconButtonColors(): IconButtonColors =
    IconButtonDefaults.iconButtonColors(
        containerColor = contentColor(),
        disabledContainerColor = contentColor().disabled(),
    )

@Composable
internal fun ButtonVariant.outlinedButtonColors(): ButtonColors = ButtonDefaults.buttonColors(
    containerColor = containerColor(),
    contentColor = contentColor(),
    disabledContainerColor = containerColor().disabled(),
    disabledContentColor = MaterialTheme.colorScheme.inverseOnSurface.disabled()
)

@Composable
internal fun ButtonVariant.outlinedTextColor(enabled: Boolean): Color =
    getTextColor(baseColor = contentColor(), enabled = enabled)

@Composable
private fun getTextColor(baseColor: Color, enabled: Boolean): Color =
    if (enabled) baseColor else MaterialTheme.colorScheme.onSurface.disabled()

@Composable
private fun ButtonVariant.containerColor(): Color = when (this) {
    ButtonVariant.ERROR -> MaterialTheme.colorScheme.errorContainer
    ButtonVariant.PRIMARY -> MaterialTheme.colorScheme.primaryContainer
    ButtonVariant.SECONDARY -> MaterialTheme.colorScheme.secondaryContainer
    ButtonVariant.TERTIARY -> MaterialTheme.colorScheme.tertiaryContainer
}

@Composable
private fun ButtonVariant.contentColor(): Color = when (this) {
    ButtonVariant.ERROR -> MaterialTheme.colorScheme.error
    ButtonVariant.PRIMARY -> MaterialTheme.colorScheme.primary
    ButtonVariant.SECONDARY -> MaterialTheme.colorScheme.secondary
    ButtonVariant.TERTIARY -> MaterialTheme.colorScheme.tertiary
}

@Composable
private fun ButtonVariant.onContentColor(): Color = when (this) {
    ButtonVariant.ERROR -> MaterialTheme.colorScheme.onError
    ButtonVariant.PRIMARY -> MaterialTheme.colorScheme.onPrimary
    ButtonVariant.SECONDARY -> MaterialTheme.colorScheme.onSecondary
    ButtonVariant.TERTIARY -> MaterialTheme.colorScheme.onTertiary
}