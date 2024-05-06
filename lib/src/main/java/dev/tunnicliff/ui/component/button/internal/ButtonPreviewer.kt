package dev.tunnicliff.ui.component.button.internal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.button.ButtonVariant
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

internal data class ButtonPreviewerParams(
    val enabled: Boolean,
    val variant: ButtonVariant
)

@Composable
internal fun ButtonPreviewer(
    theme: PreviewerTheme,
    content: @Composable (ButtonPreviewerParams) -> Unit
) {
    ThemedPreviewer(theme) {
        Box(modifier = Modifier.padding(start = 8.dp)) {
            Column {
                ButtonVariant.entries.forEach { variant ->
                    Text(text = variant.name)

                    listOf(true, false).forEach { enabled ->
                        content(
                            ButtonPreviewerParams(
                                variant = variant,
                                enabled = enabled
                            )
                        )
                    }
                }
            }
        }
    }
}
