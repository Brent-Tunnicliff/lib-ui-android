// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.button.internal.ButtonPreviewer
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
        modifier = modifier.sizeIn(
            minHeight = Constants.MINIMUM_TOUCH_SIZE.dp,
            minWidth = Constants.MINIMUM_TOUCH_SIZE.dp
        ),
    ) {
        Text(
            text = text,
            color = variant.outlinedTextColor(enabled = enabled)
        )
    }
}

@Preview
@Composable
private fun PreviewLightTheme() = PreviewContent(PreviewerTheme.LIGHT)

@Preview
@Composable
private fun PreviewDarkTheme() = PreviewContent(PreviewerTheme.DARK)

@Composable
private fun PreviewContent(theme: PreviewerTheme) {
    ButtonPreviewer(theme) { params ->
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
            text = Constants.VERY_LONG_TEXT,
            onClick = {},
            variant = params.variant,
            enabled = params.enabled
        )
    }
}