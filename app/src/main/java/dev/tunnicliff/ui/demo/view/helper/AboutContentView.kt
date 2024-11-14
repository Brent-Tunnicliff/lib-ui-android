// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

package dev.tunnicliff.ui.demo.view.helper

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import dev.tunnicliff.ui.component.text.ThemedText

@Composable
fun AboutContentView() {
    ThemedText(
        text = "Hello Joe!",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}