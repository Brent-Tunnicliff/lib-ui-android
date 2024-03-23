package dev.tunnicliff.ui.demo.view

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.tunnicliff.ui.demo.view.helper.PreviewRouter
import dev.tunnicliff.ui.demo.view.helper.Router
import dev.tunnicliff.ui.theme.ThemedPreviewer


@Composable
fun ComponentListView(router: Router) {
    Button(onClick = { router.navigateToCardDemoView() }) {
        Text(text = "Placeholder")
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ThemedPreviewer {
        ComponentListView(router = PreviewRouter())
    }
}

const val ComponentListViewRoute = "ComponentListView"

fun NavGraphBuilder.componentListView(router: Router) {
    composable(ComponentListViewRoute) {
        ComponentListView(router)
    }
}

fun NavController.navigateToComponentListView() {
    this.navigate(ComponentListViewRoute)
}