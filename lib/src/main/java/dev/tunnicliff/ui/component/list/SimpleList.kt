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
import dev.tunnicliff.ui.component.list.internal.ListPreviewerParams
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
private fun PreviewLightModePrimary() {
    ListPreviewer(
        PreviewerTheme.LIGHT,
        ListVariant.PRIMARY
    ) {
        PreviewContent(it)
    }
}

@Preview
@Composable
private fun PreviewLightModeSecondary() {
    ListPreviewer(
        PreviewerTheme.LIGHT,
        ListVariant.SECONDARY
    ) {
        PreviewContent(it)
    }
}

@Preview
@Composable
private fun PreviewLightModeSurface() {
    ListPreviewer(
        PreviewerTheme.LIGHT,
        ListVariant.SURFACE
    ) {
        PreviewContent(it)
    }
}

@Preview
@Composable
private fun PreviewLightModeTertiary() {
    ListPreviewer(
        PreviewerTheme.LIGHT,
        ListVariant.TERTIARY
    ) {
        PreviewContent(it)
    }
}

// endregion

// region Preview - Dark

@Preview
@Composable
private fun PreviewDarkModePrimary() {
    ListPreviewer(
        PreviewerTheme.DARK,
        ListVariant.PRIMARY
    ) {
        PreviewContent(it)
    }
}

@Preview
@Composable
private fun PreviewDarkModeSecondary() {
    ListPreviewer(
        PreviewerTheme.DARK,
        ListVariant.SECONDARY
    ) {
        PreviewContent(it)
    }
}

@Preview
@Composable
private fun PreviewDarkModeSurface() {
    ListPreviewer(
        PreviewerTheme.DARK,
        ListVariant.SURFACE
    ) {
        PreviewContent(it)
    }
}

@Preview
@Composable
private fun PreviewDarkModeTertiary() {
    ListPreviewer(
        PreviewerTheme.DARK,
        ListVariant.TERTIARY
    ) {
        PreviewContent(it)
    }
}

// endregion

@Composable
private fun PreviewContent(params: ListPreviewerParams) {
    val disabledText = "Disabled text"

    SimpleList(
        data = listOf(
            "Small text",
            disabledText,
            Constants.veryLongText
        ),
        modifier = params.modifier,
        variant = params.variant,
        itemClicked = { },
        itemEnabled = { it != disabledText }
    ) { item ->
        Text(item)
    }
}