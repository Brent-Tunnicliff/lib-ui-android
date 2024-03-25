package dev.tunnicliff.ui.component.toggle

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import dev.tunnicliff.ui.component.toggle.internal.TogglePreviewer
import dev.tunnicliff.ui.theme.internal.disabled

@Composable
fun LabeledCheckBox(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    variant: ToggleVariant = ToggleVariant.PRIMARY,
    enabled: Boolean = true,
    textColor: Color = Color.Unspecified
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            color = if (enabled) textColor else textColor.disabled()
        )

        Spacer(Modifier.weight(1f))

        SimpleCheckBox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled,
            variant = variant
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    TogglePreviewer { params ->
        LabeledCheckBox(
            label = "Label",
            checked = params.checked,
            onCheckedChange = {},
            variant = params.variant,
            enabled = params.enabled
        )
    }
}