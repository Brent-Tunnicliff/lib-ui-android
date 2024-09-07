// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.list.internal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.list.ListVariant
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

internal data class ListPreviewerParams(
    val modifier: Modifier,
    val variant: ListVariant
)

@Composable
internal fun ListPreviewer(
    theme: PreviewerTheme,
    variant: ListVariant,
    content: @Composable (ListPreviewerParams) -> Unit
) {
    ThemedPreviewer(theme = theme, enablePreviewScrolling = false) {
        Column {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = variant.name
            )

            content(
                ListPreviewerParams(
                    modifier = Modifier.padding(8.dp),
                    variant = variant
                )
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        }
    }
}
