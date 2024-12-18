package com.escodro.remote

import com.escodro.data.repository.datasource.MusicBrainzApi
import com.escodro.domain.model.SearchArtistResponse
import com.escodro.remote.client.SavelHttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class MusicBrainzApiImpl(
    private val httpClient: SavelHttpClient,
) : MusicBrainzApi {

    override suspend fun searchArtist(name: String): SearchArtistResponse {
        val response = httpClient.client.get(Url) {
            parameter("query", "artist:\"$name\"")
            parameter("fmt", "json")
            headers {
                httpClient.headers.forEach { (key, value) ->
                    append(key, value)
                }
            }
        }
        return response.body<SearchArtistResponse>()
    }

    private companion object {
        const val Url = "https://musicbrainz.org/ws/2/artist/"
    }
}