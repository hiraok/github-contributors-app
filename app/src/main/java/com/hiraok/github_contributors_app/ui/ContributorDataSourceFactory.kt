package com.hiraok.github_contributors_app.ui

import androidx.lifecycle.LifecycleOwner
import androidx.paging.DataSource
import com.hiraok.github_contributors_app.model.Contributor
import com.hiraok.github_contributors_app.usecase.GetContributorsUseCase
import javax.inject.Inject

class ContributorDataSourceFactory @Inject constructor(
    lifecycleOwner: LifecycleOwner,
    useCase: GetContributorsUseCase
) : DataSource.Factory<Int, Contributor>() {

    private val source = ContributorsDataSource(lifecycleOwner, useCase)

    override fun create(): DataSource<Int, Contributor> {
        return source
    }
}
