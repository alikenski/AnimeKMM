package kz.alikenski.animekmm.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun QuotesScreen(viewModel: QuotesViewModel) {
    val quoteList = viewModel.state.quoteList.observeAsState(initial = emptyList())

    LaunchedEffect(key1 = "Init") {
        viewModel.fetchQuotes()
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val state = rememberLazyListState()
            val lastIndex = quoteList.value.lastIndex
            LazyColumn(state = state,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                itemsIndexed(items = quoteList.value, itemContent = { index, quote ->
                    if (lastIndex == index) {
                        viewModel.fetchQuotes()
                    }
                    Column(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
                        Text(text = quote.anime,
                            fontWeight = FontWeight.Black)
                        Text(text = quote.character,
                            fontWeight = FontWeight.Medium)
                        Text(text = quote.quote,
                            fontStyle = FontStyle.Italic)
                    }
                })
            }
        }
    }
}

@Preview
@Composable
fun QuotesScreen() {
    QuotesScreen(QuotesViewModel())
}