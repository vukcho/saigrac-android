package com.vukcho.saigrac.inject

import com.vukcho.saigrac.navigation.NavigationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltAppModule {
    @Provides
    @Singleton
    fun provideNavigationManager(): NavigationManager = NavigationManager()
}
