// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.demo.view

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.tunnicliff.ui.component.navigation.DefaultNavHost
import dev.tunnicliff.ui.component.navigation.MenuActionOptions
import dev.tunnicliff.ui.component.navigation.SimpleTopAppBar
import dev.tunnicliff.ui.demo.BuildConfig
import dev.tunnicliff.ui.demo.R
import dev.tunnicliff.ui.demo.view.helper.AboutContentView
import dev.tunnicliff.ui.demo.view.helper.logsView
import dev.tunnicliff.ui.demo.view.helper.menuOptionView
import dev.tunnicliff.ui.demo.view.helper.navigateToLogsView
import dev.tunnicliff.ui.demo.view.helper.navigateToMenuOptionView
import dev.tunnicliff.ui.screen.aboutView
import dev.tunnicliff.ui.theme.AppTheme
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

@Composable
fun App() {
    val context = LocalContext.current
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    AppTheme {
        Scaffold(topBar = {
            SimpleTopAppBar(
                navController = navController,
                title = currentBackStackEntry?.destination?.label?.toString() ?: "",
                menuActionOptions = MenuActionOptions(
                    navHostController = navController,
                    navigateToLogs = { navController.navigateToLogsView() },
                    additionalOptions = listOf(
                        MenuActionOptions.Option("Option 1") {
                            navController.navigateToMenuOptionView(
                                1
                            )
                        },
                        MenuActionOptions.Option("Option 2") {
                            navController.navigateToMenuOptionView(
                                2
                            )
                        },
                        MenuActionOptions.Option("Option 3") {
                            navController.navigateToMenuOptionView(
                                3
                            )
                        },
                        MenuActionOptions.Option("Option 4") {
                            navController.navigateToMenuOptionView(
                                4
                            )
                        }
                    )
                )
            )
        }) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                DefaultNavHost(
                    navController = navController,
                    startDestination = START_DESTINATION
                ) {
                    aboutView(
                        context = context,
                        appName = context.getString(R.string.app_name),
                        repoLink = Uri.parse(BuildConfig.REPO_LINK)
                    ) {
                        AboutContentView()
                    }

                    cardDemoView(context)

                    componentListView(
                        navigateToCardDemoView = { navController.navigateToCardDemoView() }
                    )

                    logsView()

                    menuOptionView()
                }
            }
        }
    }
}

// region Preview

@Preview
@Composable
private fun PreviewLightTheme() = PreviewContent(PreviewerTheme.LIGHT)

@Preview
@Composable
private fun PreviewDarkTheme() = PreviewContent(PreviewerTheme.DARK)

@Composable
private fun PreviewContent(theme: PreviewerTheme) {
    ThemedPreviewer(theme, enablePreviewScrolling = false) {
        App()
    }
}

// endregion
