package dev.tunnicliff.ui.component.button

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.button.internal.ButtonPreviewer
import dev.tunnicliff.ui.component.button.internal.ButtonPreviewerParams
import dev.tunnicliff.ui.helper.Constants
import dev.tunnicliff.ui.theme.PreviewerTheme

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
        modifier = modifier.sizeIn(
            minHeight = Constants.MINIMUM_TOUCH_SIZE.dp,
            minWidth = Constants.MINIMUM_TOUCH_SIZE.dp
        ),
        colors = variant.iconButtonColors(),
        enabled = enabled
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = variant.filledTextColor(enabled = enabled),
            modifier = Modifier.fillMaxSize(0.8f)
        )
    }
}

@Preview
@Composable
private fun PreviewLightTheme() {
    ButtonPreviewer(PreviewerTheme.LIGHT) {
        PreviewContent(it)
    }
}

@Preview
@Composable
private fun PreviewDarkTheme() {
    ButtonPreviewer(PreviewerTheme.DARK) {
        PreviewContent(it)
    }
}

@Composable
private fun PreviewContent(params: ButtonPreviewerParams) {
    SimpleIconButton(
        icon = Icons.Default.Add,
        contentDescription = "Account button",
        onClick = {},
        variant = params.variant,
        enabled = params.enabled
    )
}
