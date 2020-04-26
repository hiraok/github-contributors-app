package com.hiraok.github_contributors_app.usecase

import androidx.lifecycle.LiveData
import com.hiraok.github_contributors_app.model.Contributor

interface GetContributorsUseCase {
    suspend fun execute(page: Int): LiveData<List<Contributor>>
}