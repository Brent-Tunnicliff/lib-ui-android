package dev.tunnicliff.ui.component.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.tunnicliff.ui.component.button.internal.ButtonPreviewer
import dev.tunnicliff.ui.component.button.internal.ButtonPreviewerParams
import dev.tunnicliff.ui.helper.Constants
import dev.tunnicliff.ui.theme.PreviewerTheme

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
        SimpleButton(
            text = "Button",
            onClick = {},
            variant = params.variant,
            enabled = params.enabled
        )

        SimpleButton(
            text = "Button",
            onClick = {},
            variant = params.variant,
            enabled = params.enabled,
            modifier = Modifier.fillMaxWidth()
        )

        SimpleButton(
            text = Constants.veryLongText,
            onClick = {},
            variant = params.variant,
            enabled = params.enabled
        )
    }
}