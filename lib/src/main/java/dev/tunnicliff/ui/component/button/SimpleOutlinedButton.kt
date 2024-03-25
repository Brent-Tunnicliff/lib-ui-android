package dev.tunnicliff.ui.component.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.tunnicliff.ui.helper.Constants
import dev.tunnicliff.ui.theme.ThemedPreviewer

@Composable
fun SimpleOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.PRIMARY,
    enabled: Boolean = true
) {
    OutlinedButton(
        onClick = onClick,
        colors = variant.outlinedButtonColors(),
        enabled = enabled,
        modifier = modifier,
    ) {
        Text(
            text = text,
            color = variant.outlinedTextColor(enabled = enabled)
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
                        SimpleOutlinedButton(
                            text = "Button",
                            onClick = {},
                            variant = variant,
                            enabled = enabled
                        )
                    }
                }
            }

            SimpleOutlinedButton(
                text = Constants.veryLongText,
                onClick = {}
            )
        }
    }
}