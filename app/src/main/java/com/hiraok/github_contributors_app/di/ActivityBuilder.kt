package com.hiraok.github_contributors_app.di

import androidx.lifecycle.ViewModel
import com.hiraok.github_contributors_app.ui.MainActivity
import com.hiraok.github_contributors_app.ui.MainViewModel
import com.hiraok.github_contributors_app.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            ActivityModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(
        mainViewModel: MainViewModel
    ): ViewModel

}