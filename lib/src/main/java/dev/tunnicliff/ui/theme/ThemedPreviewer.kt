package dev.tunnicliff.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ThemedPreviewer(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        AppTheme(useDarkTheme = false) {
            Surface(
                color = MaterialTheme.colorScheme.inverseSurface,
                modifier = Modifier.fillMaxWidth()
            ) {
                content()
            }
        }

        AppTheme(useDarkTheme = true) {
            Surface(
                color = MaterialTheme.colorScheme.inverseSurface,
                modifier = Modifier.fillMaxWidth()
            ) {
                content()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ThemedPreviewerPreview() {
    ThemedPreviewer {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Hello World!"
        )
    }
}