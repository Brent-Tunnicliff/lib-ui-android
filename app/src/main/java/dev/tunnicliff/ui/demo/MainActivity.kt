package dev.tunnicliff.ui.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dev.tunnicliff.ui.component.card.CardVariant
import dev.tunnicliff.ui.component.card.SimpleTextCard
import dev.tunnicliff.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        SimpleTextCard(text = "Hello World!")

                        SimpleTextCard(text = "Hello World!", variant = CardVariant.ERROR)
                    }
                }
            }
        }
    }
}
