package com.hiraok.github_contributors_app.api

import com.hiraok.github_contributors_app.api.response.ContributorResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {

    @GET("/repos/android/architecture-components-samples/contributors")
    suspend fun contributors(@Query("page") page: Int, @Query("count") count: Int = 10): List<ContributorResponse>

}

