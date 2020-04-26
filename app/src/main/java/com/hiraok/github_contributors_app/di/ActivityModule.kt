package com.hiraok.github_contributors_app.di

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.hiraok.github_contributors_app.ui.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
object ActivityModule {

    @Provides
    @JvmStatic
    fun provideLifecycleOwner(activity: MainActivity) = activity as LifecycleOwner
}