package dev.tunnicliff.ui.demo.view

import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.tunnicliff.ui.component.card.SimpleTextCard
import dev.tunnicliff.ui.component.list.BaseList
import dev.tunnicliff.ui.demo.R
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

// region Navigation

private const val ROUTE = "ComponentListView"

const val START_DESTINATION = ROUTE

fun NavGraphBuilder.componentListView(navigateToCardDemoView: () -> Unit) {
    composable(ROUTE) {
        ComponentListView(navigateToCardDemoView = navigateToCardDemoView)
    }
}

// endregion

// region View

@Composable
private fun ComponentListView(
    navigateToCardDemoView: () -> Unit
) {
    val options by remember {
        mutableStateOf(
            listOf(
                R.string.component_list_option_cards to navigateToCardDemoView,
            )
        )
    }

    BaseList(modifier = Modifier.imePadding()) {
        items(items = options) {
            SimpleTextCard(
                text = stringResource(it.first),
                onClick = it.second
            )
        }
    }
}

// endregion

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
        ComponentListView(navigateToCardDemoView = {})
    }
}

// endregion
