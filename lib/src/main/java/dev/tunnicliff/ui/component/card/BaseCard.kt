// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.button.SimpleButton
import dev.tunnicliff.ui.component.card.internal.CardPreviewer
import dev.tunnicliff.ui.helper.Constants
import dev.tunnicliff.ui.theme.PreviewerTheme

@Composable
fun BaseCard(
    modifier: Modifier = Modifier,
    variant: CardVariant = CardVariant.SURFACE,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier.padding(
            horizontal = 12.dp,
            vertical = 8.dp
        )
    ) {
        if (onClick == null) {
            Card(
                colors = variant.cardColors(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Content(content = content)
            }
        } else {
            Card(
                colors = variant.cardColors(),
                modifier = Modifier
                    .sizeIn(
                        minHeight = Constants.MINIMUM_TOUCH_SIZE.dp,
                        minWidth = Constants.MINIMUM_TOUCH_SIZE.dp
                    )
                    .fillMaxWidth(),
                onClick = onClick,
                enabled = enabled,
            ) {
                Content(content = content)
            }
        }
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .padding(
                horizontal = 12.dp,
                vertical = 8.dp
            )
    ) {
        content()
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
    CardPreviewer(theme) { params ->
        BaseCard(
            variant = params.variant,
            onClick = params.onClick,
            enabled = params.enabled
        ) {
            Column {
                Text("Hello World!")

                Text(Constants.VERY_LONG_TEXT)

                SimpleButton(
                    text = "Click me",
                    onClick = {},
                    enabled = params.enabled
                )
            }
        }
    }
}
