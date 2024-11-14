// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.navigation.internal

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.tunnicliff.ui.R
import dev.tunnicliff.ui.component.button.SimpleIconButton
import dev.tunnicliff.ui.component.navigation.MenuActionOptions
import dev.tunnicliff.ui.component.navigation.mock
import dev.tunnicliff.ui.screen.navigateToAboutView
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

@Composable
internal fun TopAppBarMenuAction(
    modifier: Modifier = Modifier,
    menuActionOptions: MenuActionOptions
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    SimpleIconButton(
        modifier = modifier,
        icon = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
        contentDescription = stringResource(R.string.top_app_var_info_action_content_description),
        onClick = { expanded = !expanded }
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(
            text = {
                Text(stringResource(R.string.top_app_var_info_action_option_about))
            },
            onClick = {
                expanded = false
                menuActionOptions.navHostController.navigateToAboutView(menuActionOptions.aboutOption)
            }
        )

        DropdownMenuItem(
            text = {
                Text(stringResource(R.string.top_app_var_info_action_option_logs))
            },
            onClick = {
                expanded = false
                menuActionOptions.logsOption.navigateToLogs()
            }
        )

        for (option in menuActionOptions.additionalOptions) {
            DropdownMenuItem(
                text = {
                    Text(option.title)
                },
                onClick = {
                    expanded = false
                    option.navigateToOption()
                }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewLightTheme() = PreviewContent(PreviewerTheme.LIGHT)

@Preview
@Composable
private fun PreviewDarkTheme() = PreviewContent(PreviewerTheme.DARK)

@Composable
private fun PreviewContent(theme: PreviewerTheme) {
    ThemedPreviewer(theme = theme) {
        TopAppBarMenuAction(menuActionOptions = MenuActionOptions.mock())
    }
}