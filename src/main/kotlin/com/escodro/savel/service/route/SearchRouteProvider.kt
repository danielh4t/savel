package com.escodro.savel.service.route

import com.escodro.savel.domain.model.SearchArtistResponse
import com.escodro.savel.domain.usecase.SearchArtist
import io.ktor.server.response.*
import io.ktor.server.routing.*

internal class SearchRouteProvider(
    private val searchArtist: SearchArtist,
) : RouteProvider {

    override val routes: Routing.() -> Unit = {
        get("/search/artist/") {
            val query = call.queryParameters["query"]
            val searchResult: Result<SearchArtistResponse> = searchArtist(name = query)
            call.respond(searchResult.getOrThrow())
        }
    }
}