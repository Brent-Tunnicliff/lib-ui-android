// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.list.internal.ListPreviewer
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
            modifier = Modifier,
            content = content,
            contentPadding = contentPadding
        )
    }
}

// region Preview - Light
@Preview(group = "light")
@Composable
private fun PreviewLightModePrimary() = PreviewContent(PreviewerTheme.LIGHT, ListVariant.PRIMARY)

@Preview(group = "light")
@Composable
private fun PreviewLightModeSecondary() =
    PreviewContent(PreviewerTheme.LIGHT, ListVariant.SECONDARY)

@Preview(group = "light")
@Composable
private fun PreviewLightModeSurface() = PreviewContent(PreviewerTheme.LIGHT, ListVariant.SURFACE)

@Preview(group = "light")
@Composable
private fun PreviewLightModeTertiary() = PreviewContent(PreviewerTheme.LIGHT, ListVariant.TERTIARY)

// endregion

// region Preview - Dark

@Preview(group = "dark")
@Composable
private fun PreviewDarkModePrimary() = PreviewContent(PreviewerTheme.DARK, ListVariant.PRIMARY)

@Preview(group = "dark")
@Composable
private fun PreviewDarkModeSecondary() = PreviewContent(PreviewerTheme.DARK, ListVariant.SECONDARY)

@Preview(group = "dark")
@Composable
private fun PreviewDarkModeSurface() = PreviewContent(PreviewerTheme.DARK, ListVariant.SURFACE)

@Preview(group = "dark")
@Composable
private fun PreviewDarkModeTertiary() = PreviewContent(PreviewerTheme.DARK, ListVariant.TERTIARY)

// endregion

@Composable
private fun PreviewContent(theme: PreviewerTheme, variant: ListVariant) {
    ListPreviewer(theme, variant) { params ->
        BaseList(
            modifier = params.modifier,
            variant = params.variant
        ) {
            items(3) { itemNumber ->
                Text("Row $itemNumber")
            }
        }
    }
}