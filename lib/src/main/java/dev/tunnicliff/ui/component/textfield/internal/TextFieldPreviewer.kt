// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.textfield.internal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.textfield.TextFieldVariant
import dev.tunnicliff.ui.helper.Constants
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

internal data class TextFieldPreviewerParams(
    val description: String,
    val enabled: Boolean,
    val initialValue: String,
    val placeholder: String?,
    val variant: TextFieldVariant
)

@Composable
internal fun TextFieldPreviewer(
    theme: PreviewerTheme,
    content: @Composable (TextFieldPreviewerParams) -> Unit
) {
    ThemedPreviewer(theme) {
        Column {
            TextFieldVariant.entries.forEach { variant ->
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = variant.name
                )

                listOf(true, false).forEach { enabled ->
                    Text(
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                        text = if (enabled) "Enabled" else "Disabled"
                    )

                    content(
                        TextFieldPreviewerParams(
                            description = "Enter value",
                            enabled = enabled,
                            initialValue = "",
                            placeholder = null,
                            variant = variant
                        )
                    )

                    content(
                        TextFieldPreviewerParams(
                            description = "Enter value",
                            enabled = enabled,
                            initialValue = "",
                            placeholder = "Placeholder",
                            variant = variant
                        )
                    )

                    content(
                        TextFieldPreviewerParams(
                            description = "Enter value",
                            enabled = enabled,
                            initialValue = "Value",
                            placeholder = null,
                            variant = variant
                        )
                    )

                    content(
                        TextFieldPreviewerParams(
                            description = "Enter value",
                            enabled = enabled,
                            initialValue = Constants.VERY_LONG_TEXT,
                            placeholder = null,
                            variant = variant
                        )
                    )

                    content(
                        TextFieldPreviewerParams(
                            description = Constants.VERY_LONG_TEXT,
                            enabled = enabled,
                            initialValue = "",
                            placeholder = null,
                            variant = variant
                        )
                    )

                    content(
                        TextFieldPreviewerParams(
                            description = Constants.VERY_LONG_TEXT,
                            enabled = enabled,
                            initialValue = "Value",
                            placeholder = null,
                            variant = variant
                        )
                    )
                }

                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
            }
        }
    }
}