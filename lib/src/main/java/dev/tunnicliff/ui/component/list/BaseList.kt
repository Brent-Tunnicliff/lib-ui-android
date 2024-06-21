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
        modifier = modifier.fillMaxWidth(),
        color = variant.color()
    ) {
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            content = content,
            contentPadding = contentPadding
        )
    }
}

// region Preview - Light
@Preview(group = "light")
@Composable
private fun PreviewLightModePrimary() {
    ListPreviewer(
        PreviewerTheme.LIGHT,
        ListVariant.PRIMARY
    ) {
        PreviewContent(it)
    }
}

@Preview(group = "light")
@Composable
private fun PreviewLightModeSecondary() {
    ListPreviewer(
        PreviewerTheme.LIGHT,
        ListVariant.SECONDARY
    ) {
        PreviewContent(it)
    }
}

@Preview(group = "light")
@Composable
private fun PreviewLightModeSurface() {
    ListPreviewer(
        PreviewerTheme.LIGHT,
        ListVariant.SURFACE
    ) {
        PreviewContent(it)
    }
}

@Preview(group = "light")
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

@Preview(group = "dark")
@Composable
private fun PreviewDarkModePrimary() {
    ListPreviewer(
        PreviewerTheme.DARK,
        ListVariant.PRIMARY
    ) {
        PreviewContent(it)
    }
}

@Preview(group = "dark")
@Composable
private fun PreviewDarkModeSecondary() {
    ListPreviewer(
        PreviewerTheme.DARK,
        ListVariant.SECONDARY
    ) {
        PreviewContent(it)
    }
}

@Preview(group = "dark")
@Composable
private fun PreviewDarkModeSurface() {
    ListPreviewer(
        PreviewerTheme.DARK,
        ListVariant.SURFACE
    ) {
        PreviewContent(it)
    }
}

@Preview(group = "dark")
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
    BaseList(
        modifier = params.modifier,
        variant = params.variant
    ) {
        items(3) { itemNumber ->
            Text("Row $itemNumber")
        }
    }
}