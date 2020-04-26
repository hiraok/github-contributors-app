package com.hiraok.github_contributors_app.usecase

import com.hiraok.github_contributors_app.usecase.GetContributorsUseCase
import com.hiraok.github_contributors_app.usecase.GetContributorsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun getContributorsUseCase(getContributorsUseCase: GetContributorsUseCaseImpl): GetContributorsUseCase

}