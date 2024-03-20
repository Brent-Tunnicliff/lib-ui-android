package dev.tunnicliff.ui.component.card

import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.tunnicliff.ui.theme.DisabledAlpha

enum class CardVariant {
    ERROR,
    PRIMARY,
    SECONDARY,
    SURFACE,
    SURFACE_VARIANT,
    TERTIARY
}

@Composable
internal fun CardVariant.cardColors(): CardColors = CardDefaults.cardColors(
    containerColor = containerColor(),
    contentColor = contentColor(),
    disabledContainerColor = containerColor().copy(DisabledAlpha),
    disabledContentColor = MaterialTheme.colorScheme.inverseOnSurface.copy(DisabledAlpha),
)

@Composable
private fun CardVariant.containerColor(): Color = when (this) {
    CardVariant.ERROR -> MaterialTheme.colorScheme.errorContainer
    CardVariant.PRIMARY -> MaterialTheme.colorScheme.primaryContainer
    CardVariant.SECONDARY -> MaterialTheme.colorScheme.secondaryContainer
    CardVariant.SURFACE -> MaterialTheme.colorScheme.surface
    CardVariant.SURFACE_VARIANT -> MaterialTheme.colorScheme.surfaceVariant
    CardVariant.TERTIARY -> MaterialTheme.colorScheme.tertiaryContainer
}

@Composable
private fun CardVariant.contentColor(): Color = when (this) {
    CardVariant.ERROR -> MaterialTheme.colorScheme.onErrorContainer
    CardVariant.PRIMARY -> MaterialTheme.colorScheme.onPrimaryContainer
    CardVariant.SECONDARY -> MaterialTheme.colorScheme.onSecondaryContainer
    CardVariant.SURFACE -> MaterialTheme.colorScheme.onSurface
    CardVariant.SURFACE_VARIANT -> MaterialTheme.colorScheme.onSurfaceVariant
    CardVariant.TERTIARY -> MaterialTheme.colorScheme.onTertiaryContainer
}
