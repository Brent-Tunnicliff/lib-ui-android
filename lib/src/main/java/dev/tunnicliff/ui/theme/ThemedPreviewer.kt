package dev.tunnicliff.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
fun ThemedPreviewer(
    theme: PreviewerTheme,
    content: @Composable () -> Unit
) {
    AppTheme(useDarkTheme = theme == PreviewerTheme.DARK) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.padding(4.dp)) {
                    content()
                }
            }
        }
    }
}

enum class PreviewerTheme {
    DARK,
    LIGHT
}

@Preview
@Composable
private fun PreviewLightTheme() {
    ThemedPreviewer(PreviewerTheme.LIGHT) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Hello World!"
        )
    }
}

@Preview
@Composable
private fun PreviewDarkTheme() {
    ThemedPreviewer(PreviewerTheme.DARK) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Hello World!"
        )
    }
}