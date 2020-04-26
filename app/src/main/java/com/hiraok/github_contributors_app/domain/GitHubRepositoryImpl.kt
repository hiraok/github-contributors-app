package com.hiraok.github_contributors_app.domain

import com.hiraok.github_contributors_app.api.GitHubApi
import com.hiraok.github_contributors_app.api.response.ContributorResponse
import com.hiraok.github_contributors_app.model.Contributor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(
    private val api: GitHubApi
) : GitHubRepository {
    override suspend fun findContributorAll(page: Int): Flow<List<Contributor>> = flow {
        emit(
            api.contributors(page).map {
                it.toDomain()
            }
        )
    }

    private fun ContributorResponse.toDomain(): Contributor {
        return Contributor(
            id = login,
            avatarUrl = avatarUrl
        )
    }
}