package kz.alikenski.animekmm.android

import androidx.lifecycle.LiveData
import kz.alikenski.animekmm.Network.QuoteModel

data class ScreenState(
    val quoteList: LiveData<List<QuoteModel>>
)