package com.molette.app.joursferies.data.network

import retrofit2.http.GET
import retrofit2.http.Path

interface GouvAPI {

    companion object{
        const val PATH_ZONE = "zone"
        const val PATH_YEAR = "year"
    }

    @GET("{$PATH_ZONE}/{$PATH_YEAR}.json")
    suspend fun getHolidays(
        @Path("$PATH_ZONE") zone: String,
        @Path("$PATH_YEAR") year: String
    ): Map<String, String>
}

