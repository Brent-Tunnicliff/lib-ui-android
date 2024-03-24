package dev.tunnicliff.ui.demo.view

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.tunnicliff.ui.theme.ThemedPreviewer

// region View

@Composable
fun ComponentListView(navigateToCardDemoView: () -> Unit) {
    Button(onClick = navigateToCardDemoView) {
        Text(text = "Placeholder")
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ThemedPreviewer {
        ComponentListView(navigateToCardDemoView = {})
    }
}

// endregion

// region Navigation

private const val ROUTE = "ComponentListView"

const val START_DESTINATION = ROUTE

fun NavGraphBuilder.componentListView(navigateToCardDemoView: () -> Unit) {
    composable(ROUTE) {
        ComponentListView(navigateToCardDemoView = navigateToCardDemoView)
    }
}

fun NavController.navigateToComponentListView() {
    this.navigate(ROUTE)
}

// endregion
