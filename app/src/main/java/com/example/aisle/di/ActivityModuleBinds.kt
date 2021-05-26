package com.example.aisle.di

import com.example.aisle.repos.repository.ApiRepository
import com.example.aisle.repos.repositoryImpl.ApiRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ActivityModuleBinds {

    @Binds
    abstract fun provideApiRepository(impl: ApiRepositoryImpl): ApiRepository
}