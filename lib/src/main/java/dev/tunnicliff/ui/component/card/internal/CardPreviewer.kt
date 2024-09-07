// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.card.internal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.card.CardVariant
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

internal data class CardPreviewerParams(
    val enabled: Boolean,
    val onClick: (() -> Unit)?,
    val variant: CardVariant
)

@Composable
internal fun CardPreviewer(
    theme: PreviewerTheme,
    content: @Composable (CardPreviewerParams) -> Unit
) {
    ThemedPreviewer(theme) {
        Surface(
            // Using inverse makes it easier to see the cards.
            color = MaterialTheme.colorScheme.inverseSurface
        ) {
            Column {
                CardVariant.entries.forEach { variant ->
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = variant.name
                    )

                    content(
                        CardPreviewerParams(
                            enabled = true,
                            onClick = null,
                            variant = variant
                        )
                    )

                    listOf(true, false).forEach { enabled ->
                        content(
                            CardPreviewerParams(
                                enabled = enabled,
                                onClick = {},
                                variant = variant
                            )
                        )
                    }

                    HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
                }
            }
        }
    }
}
