// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.theme.internal

import androidx.compose.ui.graphics.Color

private const val DISABLED_ALPHA = 0.34f
internal fun Color.disabled(): Color = this.copy(DISABLED_ALPHA)