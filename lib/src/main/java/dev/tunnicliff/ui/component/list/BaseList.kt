package dev.tunnicliff.ui.component.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.list.internal.ListPreviewer
import dev.tunnicliff.ui.component.list.internal.ListPreviewerParams
import dev.tunnicliff.ui.theme.PreviewerTheme

@Composable
fun BaseList(
    modifier: Modifier = Modifier,
    variant: ListVariant = ListVariant.SURFACE,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: LazyListScope.() -> Unit
) {
    Surface(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        color = variant.color()
    ) {
        LazyColumn(
            content = content,
            contentPadding = contentPadding
        )
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
    BaseList(
        modifier = params.modifier,
        variant = params.variant
    ) {
        items(3) { itemNumber ->
            Text("Row $itemNumber")
        }
    }
}