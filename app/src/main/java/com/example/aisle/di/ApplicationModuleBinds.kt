package com.example.aisle.di

import com.example.aisle.data.session.SessionManager
import com.example.aisle.data.session.SessionManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class ApplicationModuleBinds {
    @Singleton
    @Binds
    abstract fun provideSessionManager(impl: SessionManagerImpl): SessionManager
}