package com.hiraok.github_contributors_app.di

import com.hiraok.github_contributors_app.GhcaApplication
import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    @JvmStatic
    fun provideApplication(application: GhcaApplication) = application

}