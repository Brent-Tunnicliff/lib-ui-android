package dev.tunnicliff.ui.component.list

import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.tunnicliff.ui.component.list.internal.ListPreviewer
import dev.tunnicliff.ui.component.list.internal.ListPreviewerParams
import dev.tunnicliff.ui.theme.PreviewerTheme

@Composable
fun <Value> SimpleList(
    data: List<Value>,
    modifier: Modifier = Modifier,
    variant: ListVariant = ListVariant.SURFACE,
    key: (item: Value) -> Any,
    itemContent: @Composable (item: Value) -> Unit
) {
    BaseList(
        modifier = modifier,
        variant = variant
    ) {
        items(items = data, key = key) { item ->
            TODO("Add themed BaseCard")
//            BaseCard {
//                itemContent(item)
//            }
        }
    }
}

@Preview
@Composable
private fun PreviewLightMode() {
    ListPreviewer(PreviewerTheme.LIGHT) {
        PreviewContent(it)
    }
}

@Preview
@Composable
private fun PreviewDarkTheme() {
    ListPreviewer(PreviewerTheme.DARK) {
        PreviewContent(it)
    }
}

@Composable
private fun PreviewContent(params: ListPreviewerParams) {
    SimpleList(
        data = listOf(1, 2, 3),
        modifier = params.modifier,
        variant = params.variant,
        key = { it }
    ) { item ->
        Text("Row $item")
    }
}