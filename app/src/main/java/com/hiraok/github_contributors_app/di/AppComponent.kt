package com.hiraok.github_contributors_app.di

import android.app.Application
import com.hiraok.github_contributors_app.GhcaApplication
import com.hiraok.github_contributors_app.domain.DomainModule
import com.hiraok.github_contributors_app.ui.MainActivity
import com.hiraok.github_contributors_app.usecase.UseCaseModule
import com.hiraok.github_contributors_app.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApiComponentModule::class,
        AppModule::class,
        DomainModule::class,
        UseCaseModule::class,
        ViewModelModule::class,
        ActivityBuilder::class,
        ActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<GhcaApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
