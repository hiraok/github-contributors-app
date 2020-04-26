package com.hiraok.github_contributors_app.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.hiraok.github_contributors_app.domain.GitHubRepository
import com.hiraok.github_contributors_app.model.Contributor
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class GetContributorsUseCaseImpl @Inject constructor(
    private val gitHubRepository: GitHubRepository
) : GetContributorsUseCase {
    override suspend fun execute(page: Int): LiveData<List<Contributor>> = liveData {
        gitHubRepository.findContributorAll(page).collect {
            emit(it)
        }
    }
}