package com.hiraok.github_contributors_app.di

import android.app.Application
import com.hiraok.github_contributors_app.api.ApiComponent
import com.hiraok.github_contributors_app.api.GitHubApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal object ApiComponentModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideGitHubApi(application: Application): GitHubApi =
        ApiComponent.builder().context(application).build().gitHubApi()

}