// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.screen

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import dev.tunnicliff.ui.R
import dev.tunnicliff.ui.component.navigation.MenuActionOptions
import dev.tunnicliff.ui.component.navigation.composable
import dev.tunnicliff.ui.component.navigation.mock
import dev.tunnicliff.ui.component.text.TextStyle
import dev.tunnicliff.ui.component.text.ThemedText
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// region Navigation

private const val ARGUMENT_ABOUT_OPTION = "aboutOption"
private const val ROUTE = "AboutView"

fun NavGraphBuilder.aboutView(context: Context) =
    composable(
        route = "$ROUTE/{$ARGUMENT_ABOUT_OPTION}",
        label = context.getString(R.string.top_app_var_info_action_option_about),
        arguments = listOf(
            navArgument(name = ARGUMENT_ABOUT_OPTION) { type = NavType.StringType }
        )
    ) {
        val arguments = requireNotNull(it.arguments)

        AboutView(
            aboutOption = arguments.getString(ARGUMENT_ABOUT_OPTION)?.let { argument ->
                Json.decodeFromString(argument)
            } ?: error("Missing argument $ARGUMENT_ABOUT_OPTION")
        )
    }

internal fun NavController.navigateToAboutView(aboutOption: MenuActionOptions.AboutOption) =
    navigate("$ROUTE/${Uri.encode(Json.encodeToString(aboutOption))}")

// endregion

@Composable
private fun AboutView(aboutOption: MenuActionOptions.AboutOption) {
    val description = stringResource(R.string.about_app_description)
    val linkColor = MaterialTheme.colorScheme.primary
    val repoLink = remember { aboutOption.repoLink.toString() }
    val annotatedLinkString = remember {
        getAnnotatedLinkString(
            description = description,
            linkColor = linkColor,
            repoLink = repoLink
        )
    }

    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        ThemedText(
            text = aboutOption.appName,
            style = TextStyle.TITLE_LARGE,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        HorizontalDivider()

        ThemedText(
            text = annotatedLinkString,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        HorizontalDivider()

        ThemedText(
            text = aboutOption.aboutContent,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

private fun getAnnotatedLinkString(
    description: String,
    linkColor: Color,
    repoLink: String
): AnnotatedString = buildAnnotatedString {
    val strings = description.split("%1\$s")

    val styleCenter = SpanStyle(
        color = linkColor,
        textDecoration = TextDecoration.Underline
    )

    append(strings.first())

    withLink(LinkAnnotation.Url(repoLink)) {
        withStyle(
            style = styleCenter
        ) {
            append(repoLink)
        }
    }

    append(strings.last())
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
        AboutView(MenuActionOptions.AboutOption.mock())
    }
}