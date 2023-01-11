package kz.alikenski.animekmm.Network

import kotlinx.serialization.Serializable

@Serializable
data class QuoteModel(
    val anime: String,
    val character: String,
    val quote: String
)