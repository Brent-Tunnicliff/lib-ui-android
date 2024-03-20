package dev.tunnicliff.ui.component.card

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
        Surface(
            color = Color.Transparent,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SimpleTextCardPreview() {
    CardPreviewer {
        SimpleTextCard(
            enabled = it.enabled,
            onClick = it.onClick,
            modifier = it.modifier,
            text = "Hello World!",
            variant = it.variant
        )
    }
}
