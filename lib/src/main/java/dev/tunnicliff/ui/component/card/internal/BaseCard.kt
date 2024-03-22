package dev.tunnicliff.ui.component.card.internal

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.card.CardVariant
import dev.tunnicliff.ui.component.card.cardColors

@Composable
internal fun BaseCard(
    modifier: Modifier,
    variant: CardVariant,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    content: @Composable ColumnScope.() -> Unit
) {
    if (onClick == null) {
        Card(
            colors = variant.cardColors(),
            modifier = modifier.fillMaxWidth()
        ) {
            content()
        }
    } else {
        Card(
            colors = variant.cardColors(),
            modifier = modifier.fillMaxWidth(),
            onClick = onClick,
            enabled = enabled,
        ) {
            content()
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun BaseCardPreview() {
    CardPreviewer {
        BaseCard(
            enabled = it.enabled,
            onClick = it.onClick,
            modifier = it.modifier,
            variant = it.variant
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Hello World!"
            )
        }
    }
}
