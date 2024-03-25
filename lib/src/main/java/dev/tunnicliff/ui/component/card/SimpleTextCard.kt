package dev.tunnicliff.ui.component.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.card.internal.BaseCard
import dev.tunnicliff.ui.component.card.internal.CardPreviewer
import dev.tunnicliff.ui.helper.Constants

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
        Box(modifier = Modifier.padding(8.dp)) {
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    CardPreviewer {
        SimpleTextCard(
            enabled = it.enabled,
            onClick = it.onClick,
            modifier = it.modifier,
            text = Constants.veryLongText,
            variant = it.variant
        )
    }
}
