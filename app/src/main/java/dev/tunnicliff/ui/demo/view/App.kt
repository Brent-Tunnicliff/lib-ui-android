package dev.tunnicliff.ui.demo.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.tunnicliff.ui.component.navigation.SimpleTopAppBar
import dev.tunnicliff.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val navController = rememberNavController()

    AppTheme {
        Scaffold(topBar = {
            SimpleTopAppBar(navController = navController, title = "")
        }) {
            Box(modifier = Modifier.padding(it)) {
                NavHost(
                    navController = navController,
                    startDestination = START_DESTINATION
                ) {
                    cardDemoView()

                    componentListView(
                        navigateToCardDemoView = {
                            navController.navigateToCardDemoView()
                        }
                    )
                }
            }
        }
    }
}
