package dev.tunnicliff.ui.component.button

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.tunnicliff.ui.component.button.internal.ButtonPreviewer
import dev.tunnicliff.ui.helper.Constants
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
    ButtonPreviewer {
        SimpleButton(
            text = "Button",
            onClick = {},
            variant = it.variant,
            enabled = it.enabled
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WrappingPreview() {
    ThemedPreviewer {
        SimpleButton(
            text = Constants.veryLongText,
            onClick = {}
        )
    }
}