// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.tunnicliff.ui.component.card.BaseCard
import dev.tunnicliff.ui.component.card.CardVariant
import dev.tunnicliff.ui.component.list.SimpleList
import dev.tunnicliff.ui.helper.Constants
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

@Composable
fun SimpleTopAppBar(
    navController: NavHostController,
    title: String = ""
) {
    var showBackButton by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(navController.currentBackStackEntryFlow) {
        navController.currentBackStackEntryFlow.collect { navBackStackEntry ->
            val destination = navBackStackEntry.destination
            val parent = destination.parent
            showBackButton = destination.route?.let {
                it != parent?.startDestinationRoute
            } ?: false
        }
    }

    AppBar(
        title = title,
        backClicked = { navController.navigateUp() },
        showBackButton = showBackButton
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(
    title: String,
    backClicked: () -> Unit,
    showBackButton: Boolean
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            AnimatedVisibility(
                visible = showBackButton,
                enter = slideInHorizontally() + expandHorizontally() + fadeIn(),
                exit = slideOutHorizontally() + shrinkHorizontally() + fadeOut()
            ) {
                IconButton(onClick = backClicked) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Preview
@Composable
private fun PreviewLightTheme() = PreviewContent(PreviewerTheme.LIGHT)

@Preview
@Composable
private fun PreviewDarkTheme() = PreviewContent(PreviewerTheme.DARK)

@Composable
private fun PreviewContent(theme: PreviewerTheme) {
    ThemedPreviewer(theme = theme, enablePreviewScrolling = false) {
        Scaffold(
            topBar = {
                AppBar(
                    title = Constants.VERY_LONG_TEXT,
                    backClicked = {},
                    showBackButton = true
                )
            }
        ) {
            SimpleList(
                data = CardVariant.entries,
                modifier = Modifier.padding(it)
            ) { variant ->
                BaseCard(variant = variant) {
                    Box(modifier = Modifier.sizeIn(minHeight = 150.dp)) {}
                }
            }
        }
    }
}
