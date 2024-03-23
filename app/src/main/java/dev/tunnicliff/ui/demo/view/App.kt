package dev.tunnicliff.ui.demo.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.tunnicliff.ui.demo.view.helper.RootRouter
import dev.tunnicliff.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val navController = rememberNavController()
    val router = remember {
        RootRouter(navController)
    }

    AppTheme {
//        Scaffold(
//            topBar = {
//                TopAppBar(
//                    title = {},
//                    navigationIcon = {
//                        NavigationBackIcon(navController = navController)
//                    }
//                )
//            }
//        ) {
//            Box(modifier = Modifier.padding(it)) {
        NavHost(
            navController = navController,
            startDestination = ComponentListViewRoute
        ) {
            cardDemoView(router)

            componentListView(router)
        }
//            }
//        }
    }
}
