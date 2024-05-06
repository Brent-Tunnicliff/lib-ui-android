package dev.tunnicliff.ui.component.list.internal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.list.ListVariant
import dev.tunnicliff.ui.theme.AppTheme
import dev.tunnicliff.ui.theme.PreviewerTheme

internal data class ListPreviewerParams(
    val modifier: Modifier,
    val variant: ListVariant
)

@Composable
internal fun ListPreviewer(
    theme: PreviewerTheme,
    content: @Composable (ListPreviewerParams) -> Unit
) {
    // We are unable to use `ThemedPreviewer`
    // because the multiple lazy columns cause rendering errors.
    AppTheme(useDarkTheme = theme == PreviewerTheme.DARK) {
        Surface(
            // Using inverse makes it easier to see the cards.
            color = MaterialTheme.colorScheme.inverseSurface
        ) {
            Column {
                ListVariant.entries.forEach { variant ->
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
    }
}
