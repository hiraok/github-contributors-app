package com.hiraok.github_contributors_app.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
