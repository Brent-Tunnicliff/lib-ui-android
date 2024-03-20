package dev.tunnicliff.ui.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.theme.ThemedPreviewer

internal data class CardPreviewerParams(
    val enabled: Boolean,
    val onClick: (() -> Unit)?,
    val modifier: Modifier,
    val variant: CardVariant
)

@Composable
internal fun CardPreviewer(content: @Composable ColumnScope.(CardPreviewerParams) -> Unit) {
    ThemedPreviewer {
        Column {
            CardVariant.entries.forEach { variant ->
                content(
                    CardPreviewerParams(
                        enabled = true,
                        onClick = null,
                        modifier = Modifier.padding(8.dp),
                        variant = variant
                    )
                )

                listOf(true, false).forEach { enabled ->
                    content(
                        CardPreviewerParams(
                            enabled = enabled,
                            onClick = {},
                            modifier = Modifier.padding(8.dp),
                            variant = variant
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CardPreviewerPreview() {
    CardPreviewer { params ->
        BaseCard(
            modifier = params.modifier,
            variant = params.variant,
            onClick = params.onClick,
            enabled = params.enabled
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Hello World!"
            )
        }
    }
}