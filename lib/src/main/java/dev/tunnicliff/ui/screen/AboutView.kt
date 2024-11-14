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
import dev.tunnicliff.ui.R
import dev.tunnicliff.ui.component.navigation.composable
import dev.tunnicliff.ui.component.text.TextStyle
import dev.tunnicliff.ui.component.text.ThemedText
import dev.tunnicliff.ui.helper.Constants
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

// region Navigation

private const val ROUTE = "AboutView"

fun NavGraphBuilder.aboutView(
    context: Context,
    appName: String,
    repoLink: Uri,
    appSpecificContent: @Composable () -> Unit
) =
    composable(
        route = ROUTE,
        label = context.getString(R.string.top_app_var_info_action_option_about)
    ) {
        AboutView(
            appName = appName,
            repoLink = repoLink,
            appSpecificContent = appSpecificContent
        )
    }

internal fun NavController.navigateToAboutView() =
    navigate(ROUTE)

// endregion

@Composable
private fun AboutView(
    appName: String,
    repoLink: Uri,
    appSpecificContent: @Composable () -> Unit
) {
    val description = stringResource(R.string.about_app_description)
    val linkColor = MaterialTheme.colorScheme.primary
    val annotatedLinkString = remember {
        getAnnotatedLinkString(
            description = description,
            linkColor = linkColor,
            repoLink = repoLink.toString()
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
            text = appName,
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

        appSpecificContent()
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
        AboutView(
            appName = "Demo App",
            repoLink = Uri.parse("https://github.com/Brent-Tunnicliff/lib-ui-android")
        ) {
            ThemedText(Constants.TEXT_LONGER_THAN_SCREEN)
        }
    }
}