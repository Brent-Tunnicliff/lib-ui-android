package dev.tunnicliff.ui.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.tunnicliff.ui.demo.view.ComponentListViewRoute
import dev.tunnicliff.ui.demo.view.cardDemoView
import dev.tunnicliff.ui.demo.view.componentListView
import dev.tunnicliff.ui.demo.view.helper.RootRouter
import dev.tunnicliff.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val router = remember {
                RootRouter(navController)
            }

            AppTheme {
                NavHost(
                    navController = navController,
                    startDestination = ComponentListViewRoute
                ) {
                    cardDemoView(router)

                    componentListView(router)
                }
            }
        }
    }
}
