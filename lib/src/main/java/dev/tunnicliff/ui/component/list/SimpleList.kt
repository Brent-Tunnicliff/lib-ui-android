package dev.tunnicliff.ui.component.list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.card.BaseCard
import dev.tunnicliff.ui.component.card.CardVariant
import dev.tunnicliff.ui.component.list.internal.ListPreviewer
import dev.tunnicliff.ui.helper.Constants
import dev.tunnicliff.ui.theme.PreviewerTheme

@Composable
fun <Value> SimpleList(
    data: List<Value>,
    modifier: Modifier = Modifier,
    variant: ListVariant = ListVariant.SURFACE,
    key: ((Value) -> Any)? = null,
    itemClicked: ((Value) -> Unit)? = null,
    itemEnabled: ((Value) -> Boolean) = { true },
    itemVariant: CardVariant = variant.defaultCardVariant(),
    itemContent: @Composable (item: Value) -> Unit
) {
    BaseList(
        modifier = modifier,
        variant = variant
    ) {
        items(items = data, key = key) { item ->
            BaseCard(
                modifier = Modifier.padding(
                    vertical = 4.dp,
                ),
                variant = itemVariant,
                onClick = itemClicked?.let { { it(item) } },
                enabled = itemEnabled(item),
            ) {
                itemContent(item)
            }
        }
    }
}

// region Preview - Light
@Preview
@Composable
private fun PreviewLightModePrimary() = PreviewContent(PreviewerTheme.LIGHT, ListVariant.PRIMARY)

@Preview
@Composable
private fun PreviewLightModeSecondary() =
    PreviewContent(PreviewerTheme.LIGHT, ListVariant.SECONDARY)

@Preview
@Composable
private fun PreviewLightModeSurface() = PreviewContent(PreviewerTheme.LIGHT, ListVariant.SURFACE)

@Preview
@Composable
private fun PreviewLightModeTertiary() = PreviewContent(PreviewerTheme.LIGHT, ListVariant.TERTIARY)

// endregion

// region Preview - Dark

@Preview
@Composable
private fun PreviewDarkModePrimary() = PreviewContent(PreviewerTheme.DARK, ListVariant.PRIMARY)

@Preview
@Composable
private fun PreviewDarkModeSecondary() = PreviewContent(PreviewerTheme.DARK, ListVariant.SECONDARY)

@Preview
@Composable
private fun PreviewDarkModeSurface() = PreviewContent(PreviewerTheme.DARK, ListVariant.SURFACE)

@Preview
@Composable
private fun PreviewDarkModeTertiary() = PreviewContent(PreviewerTheme.DARK, ListVariant.TERTIARY)

// endregion

@Composable
private fun PreviewContent(theme: PreviewerTheme, variant: ListVariant) {
    val disabledText = "Disabled text"

    ListPreviewer(theme, variant) { params ->
        SimpleList(
            data = listOf(
                "Small text",
                disabledText,
                Constants.VERY_LONG_TEXT
            ),
            modifier = params.modifier,
            variant = params.variant,
            itemClicked = { },
            itemEnabled = { it != disabledText }
        ) { item ->
            Text(item)
        }
    }
}