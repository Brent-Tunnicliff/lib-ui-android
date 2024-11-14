// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import dev.tunnicliff.ui.component.navigation.MenuActionOptions.Option

/**
 * Configures the Menu used in the `SimpleTopAppBar`.
 *
 * Contains on click listeners for menu items I always want to be present.
 * Then the option to also add additional options specific to that app if needed.
 */
data class MenuActionOptions(
    val navHostController: NavHostController,
    val navigateToLogs: () -> Unit,
    val additionalOptions: List<Option> = emptyList()
) {
    data class Option(
        val title: String,
        val navigateToOption: () -> Unit
    ) {
        internal companion object
    }

    internal companion object
}

// region Mocks

@Composable
internal fun MenuActionOptions.Companion.mock(
    navHostController: NavHostController = NavHostController(LocalContext.current),
    navigateToLogs: () -> Unit = {},
    additionalOptions: List<Option> = listOf(
        Option.mock("Option 1"),
        Option.mock("Option 2"),
        Option.mock("Option 3"),
        Option.mock("Option 4"),
    )
): MenuActionOptions = MenuActionOptions(
    navHostController = navHostController,
    navigateToLogs = navigateToLogs,
    additionalOptions = additionalOptions
)

internal fun Option.Companion.mock(
    title: String = "Hello world",
    navigateToOption: () -> Unit = {}
): Option = Option(
    title = title,
    navigateToOption = navigateToOption
)

// endregion
