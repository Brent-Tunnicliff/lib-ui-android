// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.toggle.internal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.toggle.ToggleVariant
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

internal data class TogglePreviewerParams(
    val checked: Boolean,
    val enabled: Boolean,
    val variant: ToggleVariant
)

@Composable
internal fun TogglePreviewer(
    theme: PreviewerTheme,
    content: @Composable (TogglePreviewerParams) -> Unit
) {
    ThemedPreviewer(theme) {
        Box(modifier = Modifier.padding(start = 8.dp)) {
            Column {
                ToggleVariant.entries.forEach { variant ->
                    Text(text = variant.name)

                    listOf(true, false).forEach { checked ->
                        Text(text = "Checked: $checked")

                        listOf(true, false).forEach { enabled ->
                            content(
                                TogglePreviewerParams(
                                    checked = checked,
                                    enabled = enabled,
                                    variant = variant
                                )
                            )
                        }
                    }

                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    }
}
