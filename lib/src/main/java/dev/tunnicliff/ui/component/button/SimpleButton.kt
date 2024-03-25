package dev.tunnicliff.ui.component.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.tunnicliff.ui.theme.ThemedPreviewer

@Composable
fun SimpleButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.PRIMARY,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        colors = variant.filledButtonColors(),
        enabled = enabled,
        modifier = modifier,
    ) {
        Text(
            text = text,
            color = variant.filledTextColor(enabled = enabled)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ThemedPreviewer {
        Column {
            ButtonVariant.entries.forEach { variant ->
                Row {
                    listOf(true, false).forEach { enabled ->
                        SimpleButton(
                            text = "Button",
                            onClick = {},
                            variant = variant,
                            enabled = enabled
                        )
                    }
                }
            }

            SimpleButton(
                text = "This is a very, very long piece of text to see how it is handled in the preview",
                onClick = {}
            )
        }
    }
}