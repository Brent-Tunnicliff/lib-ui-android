package dev.tunnicliff.ui.component.card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.tunnicliff.ui.component.card.internal.CardPreviewer
import dev.tunnicliff.ui.component.card.internal.CardPreviewerParams
import dev.tunnicliff.ui.helper.Constants
import dev.tunnicliff.ui.theme.PreviewerTheme

@Composable
fun SimpleTextCard(
    text: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    variant: CardVariant = CardVariant.SURFACE
) {
    BaseCard(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        variant = variant
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
private fun PreviewLightTheme() {
    CardPreviewer(PreviewerTheme.LIGHT) {
        PreviewContent(it)
    }
}

@Preview
@Composable
private fun PreviewDarkTheme() {
    CardPreviewer(PreviewerTheme.DARK) {
        PreviewContent(it)
    }
}

@Composable
private fun PreviewContent(params: CardPreviewerParams) {
    SimpleTextCard(
        enabled = params.enabled,
        onClick = params.onClick,
        modifier = params.modifier,
        text = Constants.VERY_LONG_TEXT,
        variant = params.variant
    )
}
