package dev.tunnicliff.ui.component.list

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.tunnicliff.ui.component.card.CardVariant

enum class ListVariant {
    PRIMARY,
    SECONDARY,
    SURFACE,
    TERTIARY
}

@Composable
internal fun ListVariant.color(): Color = when (this) {
    ListVariant.PRIMARY -> MaterialTheme.colorScheme.primaryContainer.background()
    ListVariant.SECONDARY -> MaterialTheme.colorScheme.secondaryContainer.background()
    ListVariant.SURFACE -> MaterialTheme.colorScheme.surfaceVariant.background()
    ListVariant.TERTIARY -> MaterialTheme.colorScheme.tertiaryContainer.background()
}

internal fun ListVariant.defaultCardVariant(): CardVariant = when (this) {
    ListVariant.PRIMARY -> CardVariant.PRIMARY
    ListVariant.SECONDARY -> CardVariant.SECONDARY
    ListVariant.SURFACE -> CardVariant.SURFACE
    ListVariant.TERTIARY -> CardVariant.TERTIARY
}

private const val ALPHA = 0.90f
private fun Color.background(): Color = this.copy(ALPHA)