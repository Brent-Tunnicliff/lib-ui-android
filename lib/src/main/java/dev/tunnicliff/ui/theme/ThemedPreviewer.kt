package dev.tunnicliff.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ThemedPreviewer(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        ContentSection(theme = Theme.LIGHT, content = content)
        HorizontalDivider()
        ContentSection(theme = Theme.DARK, content = content)
    }
}

private enum class Theme {
    DARK,
    LIGHT
}

private fun Theme.isDark(): Boolean = this == Theme.DARK

@Composable
private fun ContentSection(theme: Theme, content: @Composable () -> Unit) {
    Box {
        AppTheme(useDarkTheme = theme.isDark()) {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "$theme theme"
                    )

                    HorizontalDivider()

                    Box(modifier = Modifier.padding(4.dp)) {
                        content()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ThemedPreviewer {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Hello World!"
        )
    }
}