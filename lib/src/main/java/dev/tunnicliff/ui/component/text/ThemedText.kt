// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.component.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.tunnicliff.ui.theme.PreviewerTheme
import dev.tunnicliff.ui.theme.ThemedPreviewer

@Composable
fun ThemedText(
    text: String,
    modifier: Modifier = Modifier,
    variant: TextVariant = TextVariant.ON_SURFACE,
    style: TextStyle = TextStyle.DEFAULT,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1
) {
    Text(
        text = text,
        modifier = modifier,
        color = variant.color(),
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        style = style.style(),
        textAlign = textAlign
    )
}

@Composable
fun ThemedText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    variant: TextVariant = TextVariant.ON_SURFACE,
    style: TextStyle = TextStyle.DEFAULT,
    textAlign: TextAlign = TextAlign.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1
) {
    Text(
        text = text,
        modifier = modifier,
        color = variant.color(),
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        style = style.style(),
        textAlign = textAlign
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
    ThemedPreviewer(theme) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            ThemedText(
                "Hello World!!!",
                modifier = Modifier.fillMaxWidth()
            )

            ThemedText(
                "Hello World!!!",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            ThemedText(
                "Hello World!!!",
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}