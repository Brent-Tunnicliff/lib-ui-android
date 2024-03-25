package dev.tunnicliff.ui.component.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import dev.tunnicliff.ui.component.button.internal.ButtonPreviewer

@Composable
fun SimpleIconButton(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.PRIMARY,
    enabled: Boolean = true
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
        colors = variant.iconButtonColors(),
        enabled = enabled
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = variant.filledTextColor(enabled = enabled)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ButtonPreviewer {
        SimpleIconButton(
            icon = Icons.Default.Add,
            contentDescription = "Account button",
            onClick = {},
            variant = it.variant,
            enabled = it.enabled
        )
    }
}
