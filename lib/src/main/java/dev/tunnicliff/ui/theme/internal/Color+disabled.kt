package dev.tunnicliff.ui.theme.internal

import androidx.compose.ui.graphics.Color

private const val DisabledAlpha = 0.34f
internal fun Color.disabled(): Color = this.copy(DisabledAlpha)