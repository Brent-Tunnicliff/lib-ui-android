// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.text

import androidx.compose.foundation.layout.Column
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
import dev.tunnicliff.ui.helper.Constants
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

@Composable
fun SimpleTextField(
    modifier: Modifier = Modifier,
    description: String,
    initialValue: String = "",
    onValueChange: (String) -> Unit
) {
    var text by remember { mutableStateOf(initialValue) }

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = {
            text = it
            onValueChange(it)
        },
        label = {
            Text(text = description)
        }
    )
}

@Preview
@Composable
private fun PreviewLightTheme() = PreviewContent(PreviewerTheme.LIGHT)

@Preview
@Composable
private fun PreviewDarkTheme() = PreviewContent(PreviewerTheme.DARK)

@Composable
private fun PreviewContent(theme: PreviewerTheme) {
    ThemedPreviewer(theme) {
        Column {
            SimpleTextField(
                description = "Enter value",
                onValueChange = {}
            )

            SimpleTextField(
                description = "Enter value",
                initialValue = "Value",
                onValueChange = {}
            )

            SimpleTextField(
                description = "Enter value",
                initialValue = Constants.VERY_LONG_TEXT,
                onValueChange = {}
            )

            SimpleTextField(
                description = Constants.VERY_LONG_TEXT,
                initialValue = "",
                onValueChange = {}
            )

            SimpleTextField(
                description = Constants.VERY_LONG_TEXT,
                initialValue = "Value",
                onValueChange = {}
            )
        }
    }
}