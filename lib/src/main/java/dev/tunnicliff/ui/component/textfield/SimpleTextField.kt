// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.tunnicliff.ui.component.textfield.internal.TextFieldPreviewer
import dev.tunnicliff.ui.theme.PreviewerTheme

@Composable
fun SimpleTextField(
    modifier: Modifier = Modifier,
    description: String,
    placeholder: String? = null,
    supportingText: String? = null,
    variant: TextFieldVariant = TextFieldVariant.SURFACE,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    initialValue: String = "",
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    onValueChange: (String) -> Unit
) {
    var text by remember { mutableStateOf(initialValue) }

    TextField(
        modifier = modifier.fillMaxWidth(),
        colors = variant.textFieldColors(),
        enabled = enabled,
        readOnly = readOnly,
        textStyle = variant.textStyle(enabled),
        value = text,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        onValueChange = {
            text = it
            onValueChange(it)
        },
        label = {
            Text(
                text = description,
                color = variant.textColor(enabled = enabled)
            )
        },
        placeholder = if (placeholder == null) null else {
            {
                Text(
                    text = placeholder,
                    color = variant.textColor(enabled = enabled)
                )
            }
        },
        supportingText = if (supportingText == null) null else {
            {
                Text(
                    text = supportingText,
                    color = variant.textColor(enabled = enabled)
                )
            }
        },
    )
}

@Preview
@Composable
private fun PreviewLightTheme() = PreviewContent(PreviewerTheme.LIGHT)

@Preview
@Composable
private fun PreviewDarkTheme() = PreviewContent(PreviewerTheme.DARK)

@Composable
private fun PreviewContent(theme: PreviewerTheme) = TextFieldPreviewer(theme) {
    SimpleTextField(
        description = it.description,
        enabled = it.enabled,
        initialValue = it.initialValue,
        placeholder = it.placeholder,
        onValueChange = {},
        variant = it.variant
    )
}
