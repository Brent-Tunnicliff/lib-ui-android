// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import dev.tunnicliff.ui.component.navigation.MenuActionOptions.AboutOption
import dev.tunnicliff.ui.component.navigation.MenuActionOptions.LogsOption
import dev.tunnicliff.ui.component.navigation.MenuActionOptions.Option
import dev.tunnicliff.ui.helper.Constants
import dev.tunnicliff.ui.helper.UriSerializer
import kotlinx.serialization.Serializable

/**
 * Configures the Menu used in the `SimpleTopAppBar`.
 *
 * Contains on click listeners for menu items I always want to be present.
 * Then the option to also add additional options specific to that app if needed.
 */
data class MenuActionOptions(
    val aboutOption: AboutOption,
    val logsOption: LogsOption,
    val navHostController: NavHostController,
    val additionalOptions: List<Option> = emptyList()
) {
    @Serializable
    data class AboutOption(
        val aboutContent: String,
        val appName: String,
        @Serializable(with = UriSerializer::class)
        val repoLink: Uri
    ) {
        internal companion object
    }

    data class LogsOption(
        // Logs is an external module that uses this ui lib,
        // so lets expect the app to handle the navigation.
        val navigateToLogs: () -> Unit
    ) {
        internal companion object
    }

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
    aboutOption: AboutOption = AboutOption.mock(),
    logsOption: LogsOption = LogsOption.mock(),
    navHostController: NavHostController = NavHostController(LocalContext.current),
    additionalOptions: List<Option> = listOf(
        Option.mock("Option 1"),
        Option.mock("Option 2"),
        Option.mock("Option 3"),
        Option.mock("Option 4"),
    )
): MenuActionOptions = MenuActionOptions(
    aboutOption = aboutOption,
    logsOption = logsOption,
    navHostController = navHostController,
    additionalOptions = additionalOptions
)

internal fun Option.Companion.mock(
    title: String = "Hello world",
    navigateToOption: () -> Unit = {}
): Option = Option(
    title = title,
    navigateToOption = navigateToOption
)


internal fun AboutOption.Companion.mock(
    aboutContent: String = Constants.TEXT_LONGER_THAN_SCREEN,
    appName: String = "Demo App",
    repoLink: Uri = Uri.parse("https://github.com/Brent-Tunnicliff/lib-ui-android")
): AboutOption = AboutOption(
    aboutContent = aboutContent,
    appName = appName,
    repoLink = repoLink
)

internal fun LogsOption.Companion.mock(
    navigateToLogs: () -> Unit = {}
): LogsOption = LogsOption(
    navigateToLogs = navigateToLogs
)

// endregion
