package com.hiraok.github_contributors_app.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.paging.PageKeyedDataSource
import com.hiraok.github_contributors_app.model.Contributor
import com.hiraok.github_contributors_app.usecase.GetContributorsUseCase
import kotlinx.coroutines.*

class ContributorsDataSource(
    private val lifeCycleOwner: LifecycleOwner,
    private val useCase: GetContributorsUseCase
) : PageKeyedDataSource<Int, Contributor>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Contributor>
    ) {

        val currentPage = 1
        GlobalScope.launch(Dispatchers.Main) {
            useCase.execute(currentPage).observe(lifeCycleOwner, Observer {
                callback.onResult(it, null, 1)
            })
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Contributor>
    ) {
        val key = params.key + 1
        GlobalScope.launch(Dispatchers.Main) {
            useCase.execute(key).observe(lifeCycleOwner, Observer {
                callback.onResult(it, null)
            })
        }

    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Contributor>
    ) {
    }

}