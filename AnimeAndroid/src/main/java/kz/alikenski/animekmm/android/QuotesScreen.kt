package kz.alikenski.animekmm.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

@Composable
fun QuotesScreen(viewModel: QuotesViewModel) {
    val quoteList = viewModel.state.quoteList.observeAsState(initial = emptyList())

    LaunchedEffect(key1 = "Init") {
        viewModel.fetchQuotes()
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val state = rememberLazyListState()
            Text(text = "Test")
//            LazyColumn(state = state,
//                verticalArrangement = Arrangement.Top,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.White)
//            ) {
//                items(count = 1, itemContent = {
//                    Text(text = "Test")
//                })
////                items(items = quoteList, count = 1, itemContent = { quote ->
////                    Column() {
////                        Text(text = quote.anime)
////                        Text(text = quote.character)
////                        Text(text = quote.quote)
////                    }
////                })
//            }
        }
    }
}

@Preview
@Composable
fun QuotesScreen() {
    QuotesScreen(QuotesViewModel())
}