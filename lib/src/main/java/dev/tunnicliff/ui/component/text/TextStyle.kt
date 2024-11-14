// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.text

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle as ComposeTextStyle

enum class TextStyle {
    DEFAULT,
    DISPLAY_LARGE,
    DISPLAY_MEDIUM,
    DISPLAY_SMALL,
    HEADLINE_LARGE,
    HEADLINE_MEDIUM,
    HEADLINE_SMALL,
    TITLE_LARGE,
    TITLE_MEDIUM,
    TITLE_SMALL,
    BODY_LARGE,
    BODY_MEDIUM,
    BODY_SMALL,
    LABEL_LARGE,
    LABEL_MEDIUM,
    LABEL_SMALL
}

@Composable
internal fun TextStyle.style(): ComposeTextStyle =
    when (this) {
        TextStyle.DEFAULT -> LocalTextStyle.current
        TextStyle.DISPLAY_LARGE -> MaterialTheme.typography.displayLarge
        TextStyle.DISPLAY_MEDIUM -> MaterialTheme.typography.displayMedium
        TextStyle.DISPLAY_SMALL -> MaterialTheme.typography.displaySmall
        TextStyle.HEADLINE_LARGE -> MaterialTheme.typography.headlineLarge
        TextStyle.HEADLINE_MEDIUM -> MaterialTheme.typography.headlineMedium
        TextStyle.HEADLINE_SMALL -> MaterialTheme.typography.headlineSmall
        TextStyle.TITLE_LARGE -> MaterialTheme.typography.headlineLarge
        TextStyle.TITLE_MEDIUM -> MaterialTheme.typography.headlineMedium
        TextStyle.TITLE_SMALL -> MaterialTheme.typography.headlineSmall
        TextStyle.BODY_LARGE -> MaterialTheme.typography.bodyLarge
        TextStyle.BODY_MEDIUM -> MaterialTheme.typography.bodyMedium
        TextStyle.BODY_SMALL -> MaterialTheme.typography.bodySmall
        TextStyle.LABEL_LARGE -> MaterialTheme.typography.labelLarge
        TextStyle.LABEL_MEDIUM -> MaterialTheme.typography.labelMedium
        TextStyle.LABEL_SMALL -> MaterialTheme.typography.labelSmall
    }