package com.hiraok.github_contributors_app.domain

import com.hiraok.github_contributors_app.model.Contributor
import kotlinx.coroutines.flow.Flow

interface GitHubRepository {

    suspend fun findContributorAll(page: Int): Flow<List<Contributor>>
}