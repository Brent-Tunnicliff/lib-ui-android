package dev.tunnicliff.ui.component.list

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class ListVariant {
    PRIMARY,
    SECONDARY,
    SURFACE,
    TERTIARY
}

@Composable
internal fun ListVariant.color(): Color = when (this) {
    ListVariant.PRIMARY -> MaterialTheme.colorScheme.primaryContainer
    ListVariant.SECONDARY -> MaterialTheme.colorScheme.secondaryContainer
    ListVariant.SURFACE -> MaterialTheme.colorScheme.surfaceVariant
    ListVariant.TERTIARY -> MaterialTheme.colorScheme.tertiaryContainer
}