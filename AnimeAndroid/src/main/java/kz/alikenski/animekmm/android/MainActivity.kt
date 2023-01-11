package kz.alikenski.animekmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = QuotesViewModel()

        setContent {
            MyApplicationTheme() {
                QuotesScreen(viewModel = viewModel)
            }
        }
    }
}
