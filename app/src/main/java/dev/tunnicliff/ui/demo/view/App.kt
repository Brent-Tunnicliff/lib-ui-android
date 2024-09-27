// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.demo.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dev.tunnicliff.ui.component.navigation.DefaultNavHost
import dev.tunnicliff.ui.component.navigation.SimpleTopAppBar
import dev.tunnicliff.ui.theme.AppTheme
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

@Composable
fun App() {
    val navController = rememberNavController()

    AppTheme {
        Scaffold(topBar = {
            SimpleTopAppBar(navController = navController, title = "Test")
        }) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                DefaultNavHost(
                    navController = navController,
                    startDestination = START_DESTINATION
                ) {
                    cardDemoView()

                    componentListView(
                        navigateToCardDemoView = { navController.navigateToCardDemoView() }
                    )
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
