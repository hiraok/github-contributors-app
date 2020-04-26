package com.hiraok.github_contributors_app.domain

import dagger.Binds
import dagger.Module

@Module
abstract class DomainModule {

    @Binds
    abstract fun provideContributorRepository(contributorRepository: GitHubRepositoryImpl): GitHubRepository
}