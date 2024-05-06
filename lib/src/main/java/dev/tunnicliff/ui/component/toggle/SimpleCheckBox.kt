package dev.tunnicliff.ui.component.toggle

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.tunnicliff.ui.component.toggle.internal.TogglePreviewer
import dev.tunnicliff.ui.component.toggle.internal.TogglePreviewerParams
import dev.tunnicliff.ui.theme.PreviewerTheme

@Composable
fun SimpleCheckBox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    variant: ToggleVariant = ToggleVariant.PRIMARY,
    enabled: Boolean = true
) {
    var value by remember { mutableStateOf(checked) }

    Checkbox(
        checked = value,
        onCheckedChange = {
            value = it
            onCheckedChange(it)
        },
        modifier = modifier,
        enabled = enabled,
        colors = variant.checkboxColors()
    )
}

@Preview
@Composable
private fun PreviewLightTheme() {
    TogglePreviewer(PreviewerTheme.LIGHT) {
        PreviewContent(it)
    }
}

@Preview
@Composable
private fun PreviewDarkTheme() {
    TogglePreviewer(PreviewerTheme.DARK) {
        PreviewContent(it)
    }
}

@Composable
private fun PreviewContent(params: TogglePreviewerParams) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        SimpleCheckBox(
            checked = params.checked,
            onCheckedChange = {},
            variant = params.variant,
            enabled = params.enabled
        )

        Text(text = if (params.enabled) "enabled" else "disabled")
    }
}