package dev.tunnicliff.ui.component.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.tunnicliff.ui.component.button.internal.ButtonPreviewer
import dev.tunnicliff.ui.component.button.internal.ButtonPreviewerParams
import dev.tunnicliff.ui.helper.Constants
import dev.tunnicliff.ui.theme.PreviewerTheme

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

@Preview
@Composable
private fun PreviewLightTheme() {
    ButtonPreviewer(PreviewerTheme.LIGHT) {
        PreviewContent(it)
    }
}

@Preview
@Composable
private fun PreviewDarkTheme() {
    ButtonPreviewer(PreviewerTheme.DARK) {
        PreviewContent(it)
    }
}

@Composable
private fun PreviewContent(params: ButtonPreviewerParams) {
    Column {
        SimpleOutlinedButton(
            text = "Button",
            onClick = {},
            variant = params.variant,
            enabled = params.enabled
        )

        SimpleOutlinedButton(
            text = "Button",
            onClick = {},
            variant = params.variant,
            enabled = params.enabled,
            modifier = Modifier.fillMaxWidth()
        )

        SimpleOutlinedButton(
            text = Constants.veryLongText,
            onClick = {},
            variant = params.variant,
            enabled = params.enabled
        )
    }
}