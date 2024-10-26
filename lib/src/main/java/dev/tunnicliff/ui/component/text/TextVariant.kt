// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class TextVariant {
    ON_BACKGROUND,
    ON_ERROR,
    ON_ERROR_CONTAINER,
    ON_PRIMARY,
    ON_PRIMARY_CONTAINER,
    ON_SECONDARY,
    ON_SECONDARY_CONTAINER,
    ON_SURFACE,
    ON_SURFACE_VARIANT,
    ON_TERTIARY,
    ON_TERTIARY_CONTAINER
}

@Composable
internal fun TextVariant.color(): Color =
    when (this) {
        TextVariant.ON_BACKGROUND -> MaterialTheme.colorScheme.onBackground
        TextVariant.ON_ERROR -> MaterialTheme.colorScheme.onError
        TextVariant.ON_ERROR_CONTAINER -> MaterialTheme.colorScheme.onErrorContainer
        TextVariant.ON_PRIMARY -> MaterialTheme.colorScheme.onPrimary
        TextVariant.ON_PRIMARY_CONTAINER -> MaterialTheme.colorScheme.onPrimaryContainer
        TextVariant.ON_SECONDARY -> MaterialTheme.colorScheme.onSecondary
        TextVariant.ON_SECONDARY_CONTAINER -> MaterialTheme.colorScheme.onSecondaryContainer
        TextVariant.ON_SURFACE -> MaterialTheme.colorScheme.onSurface
        TextVariant.ON_SURFACE_VARIANT -> MaterialTheme.colorScheme.onSurfaceVariant
        TextVariant.ON_TERTIARY -> MaterialTheme.colorScheme.onTertiary
        TextVariant.ON_TERTIARY_CONTAINER -> MaterialTheme.colorScheme.onTertiaryContainer
    }
