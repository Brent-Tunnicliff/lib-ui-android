// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.demo.view.helper

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


// region Navigation

private const val ARGUMENT_NUMBER = "number"
private const val ROUTE = "MenuOptionView"

fun NavGraphBuilder.menuOptionView() {
    composable(
        route = "$ROUTE/{$ARGUMENT_NUMBER}",
        arguments = listOf(
            navArgument(ARGUMENT_NUMBER) { type = NavType.IntType }
        )
    ) {
        val arguments = requireNotNull(it.arguments)
        MenuOptionView(
            arguments.getInt(ARGUMENT_NUMBER)
        )
    }
}

fun NavController.navigateToMenuOptionView(number: Int) {
    navigate("$ROUTE/$number")
}

// endregion

// region View

@Composable
private fun MenuOptionView(number: Int) {
    Text("Menu option view $number")
}

// endregion

// region Preview

@Preview
@Composable
private fun Preview() = MenuOptionView(1)

// endregion
