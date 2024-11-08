// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.demo.view.helper

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.component.picker.BasicPickerValue
import dev.tunnicliff.ui.component.picker.SimplePicker
import dev.tunnicliff.ui.component.textfield.SimpleTextField
import dev.tunnicliff.ui.component.toggle.LabeledSwitch
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

sealed class DemoOptionsInput {
    data class Picker<Value>(
        val description: String,
        val values: List<Option<Value>>,
        val initialValue: String = values.first().title,
        val onValueChange: (Option<Value>) -> Unit
    ) : DemoOptionsInput() {
        data class Option<Value>(
            val title: String,
            val value: Value
        )
    }

    data class Text(
        val description: String,
        val initialValue: String = "",
        val onValueChange: (String) -> Unit
    ) : DemoOptionsInput()

    data class Toggle(
        val description: String,
        val initialValue: Boolean = true,
        val onValueChange: (Boolean) -> Unit
    ) : DemoOptionsInput()
}

@Composable
fun DemoOptionsView(
    options: List<DemoOptionsInput>,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Customise the view"
        )

        options.forEach {
            Box(modifier = modifier.padding(4.dp)) {
                when (it) {
                    is DemoOptionsInput.Picker<*> -> PickerInput(it)
                    is DemoOptionsInput.Text -> TextInput(it)
                    is DemoOptionsInput.Toggle -> ToggleInput(it)
                }
            }
        }

        HorizontalDivider(modifier.padding(vertical = 8.dp))

        Text(
            modifier = Modifier.padding(8.dp),
            text = "Preview:"
        )
    }
}

@Composable
private fun <Value> PickerInput(params: DemoOptionsInput.Picker<Value>) {
    SimplePicker(
        values = params.values.map {
            BasicPickerValue(
                description = it.title,
                value = it
            )
        },
        initialValue = params.initialValue,
        onValueChanged = {
            params.onValueChange(it.value)
        }
    )
}

@Composable
private fun TextInput(params: DemoOptionsInput.Text) {
    SimpleTextField(
        description = params.description,
        initialValue = params.initialValue,
        onValueChange = {
            params.onValueChange(it)
        }
    )
}

@Composable
private fun ToggleInput(params: DemoOptionsInput.Toggle) {
    LabeledSwitch(
        label = params.description,
        checked = params.initialValue,
        onCheckedChange = params.onValueChange
    )
}

@Preview
@Composable
private fun PreviewLightTheme() {
    ThemedPreviewer(PreviewerTheme.DARK) {
        PreviewContent()
    }
}

@Preview
@Composable
private fun PreviewDarkTheme() {
    ThemedPreviewer(PreviewerTheme.DARK) {
        PreviewContent()
    }
}

@Composable
private fun PreviewContent() {
    DemoOptionsView(
        options = listOf(
            DemoOptionsInput.Text(
                "Text Input",
                onValueChange = {}
            ),
            DemoOptionsInput.Text(
                "Text Input with default value",
                initialValue = "Hello World!",
                onValueChange = {}
            ),
            DemoOptionsInput.Picker(
                "Picker",
                values = listOf("One", "Two", "Three").map {
                    DemoOptionsInput.Picker.Option(it, it)
                },
                onValueChange = {}
            ),
            DemoOptionsInput.Toggle(
                "Toggle",
                initialValue = true,
                onValueChange = {}
            ),
        )
    )
}