// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.demo.view.helper

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

// region Navigation

private const val ROUTE = "LogsView"

fun NavGraphBuilder.logsView() {
    composable(ROUTE) {
        LogsView()
    }
}

fun NavController.navigateToLogsView() {
    navigate(ROUTE)
}

// endregion

// region View

@Composable
private fun LogsView() {
    Text("Example log view")
}

// endregion

// region Preview

@Preview
@Composable
private fun Preview() = LogsView()

// endregion
