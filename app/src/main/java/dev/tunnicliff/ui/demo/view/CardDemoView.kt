package dev.tunnicliff.ui.demo.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.tunnicliff.ui.component.card.CardVariant
import dev.tunnicliff.ui.component.card.SimpleTextCard
import dev.tunnicliff.ui.demo.view.helper.DemoOptionsInput
import dev.tunnicliff.ui.demo.view.helper.DemoOptionsView
import dev.tunnicliff.ui.demo.view.helper.PreviewRouter
import dev.tunnicliff.ui.demo.view.helper.Router
import dev.tunnicliff.ui.theme.ThemedPreviewer

@Composable
fun CardDemoView(router: Router) {
    Column {
        var variant by remember {
            mutableStateOf(CardVariant.PRIMARY)
        }

        var text by remember {
            mutableStateOf("Hello World!")
        }

        DemoOptionsView(
            options = listOf(
                DemoOptionsInput.Picker(
                    description = "Variant",
                    values = CardVariant.entries.map {
                        DemoOptionsInput.Picker.Option(it.name, it)
                    },
                    initialValue = variant.name,
                    onValueChange = {
                        variant = it.value
                    }
                ),
                DemoOptionsInput.Text(
                    description = "Value",
                    initialValue = text,
                    onValueChange = {
                        text = it
                    }
                )
            )
        )

        SimpleTextCard(
            modifier = Modifier.padding(8.dp),
            text = text,
            variant = variant
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CardDemoViewPreview() {
    ThemedPreviewer {
        CardDemoView(router = PreviewRouter())
    }
}

const val CardDemoViewRoute = "CardDemoView"

fun NavGraphBuilder.cardDemoView(router: Router) {
    composable(CardDemoViewRoute) {
        CardDemoView(router)
    }
}

fun NavController.navigateToCardDemoView() {
    this.navigate(CardDemoViewRoute)
}