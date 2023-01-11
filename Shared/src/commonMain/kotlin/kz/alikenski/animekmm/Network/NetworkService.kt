package kz.alikenski.animekmm.Network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class NetworkService {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    ignoreUnknownKeys = true
                }
            )
        }
        install(HttpTimeout)
    }

    suspend fun getQuotes(page: Int): List<QuoteModel> {
        return client.get("$BASE_URL") {
            parameter("page", page)
            parameter("title", "Naruto")
            timeout {
                requestTimeoutMillis = TIMEOUT_VALUE
            }
        }.body()
    }
}