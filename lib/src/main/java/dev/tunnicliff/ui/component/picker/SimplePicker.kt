package dev.tunnicliff.ui.component.picker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tunnicliff.ui.theme.ThemedPreviewer

data class BasicPickerValue<Value>(
    val value: Value,
    val description: String = value.toString()
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <Value> SimplePicker(
    modifier: Modifier = Modifier,
    values: List<BasicPickerValue<Value>>,
    initialValue: String = values.first().description,
    variant: PickerVariant = PickerVariant.SURFACE,
    enabled: Boolean = true,
    onValueChanged: (BasicPickerValue<Value>) -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedText by remember {
        mutableStateOf(initialValue)
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = enabled && !expanded
        }
    ) {
        TextField(
            value = selectedText,
            enabled = enabled,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = variant.textFieldColors(),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            modifier = Modifier.background(variant.menuItemBackgroundColor()),
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            values.forEach { value ->
                DropdownMenuItem(
                    text = {
                        Text(text = value.description)
                    },
                    onClick = {
                        selectedText = value.description
                        expanded = false
                        onValueChanged(value)
                    },
                    enabled = enabled,
                    colors = variant.menuItemColors()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ThemedPreviewer {
        Column {
            val values = listOf("One", "Two", "Three").map {
                BasicPickerValue(it)
            }

            PickerVariant.entries.forEach { variant ->
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = variant.name
                )

                SimplePicker(
                    values = values,
                    onValueChanged = {},
                    variant = variant
                )

                SimplePicker(
                    values = values,
                    initialValue = "Please select",
                    onValueChanged = {},
                    variant = variant
                )

                SimplePicker(
                    values = values,
                    enabled = false,
                    onValueChanged = {},
                    variant = variant
                )
            }
        }
    }
}
