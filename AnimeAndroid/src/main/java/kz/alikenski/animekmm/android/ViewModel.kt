package kz.alikenski.animekmm.android

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kz.alikenski.animekmm.Network.NetworkService
import kz.alikenski.animekmm.Network.QuoteModel
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(): ViewModel() {
    private val network = NetworkService()
    private val quoteList = MutableLiveData(emptyList<QuoteModel>())
    private val page = 1

    val state = ScreenState(
        quoteList = quoteList
    )

    fun fetchQuotes() {
        viewModelScope.launch {
            val data = network.getQuotes(page = page)
            quoteList.postValue(data)
        }
    }
}