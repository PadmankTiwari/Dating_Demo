package com.example.aisle.di

import com.example.aisle.BuildConfig
import com.example.aisle.data.ApiExceptionInterceptor
import com.example.aisle.data.AuthInterceptor
import com.example.api.ApiClient
import com.example.api.model.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModuleBinds {

    @Singleton
    @Provides
    fun provideHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        apiExceptionInterceptor: ApiExceptionInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(apiExceptionInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiClient(
        authInterceptor: AuthInterceptor,
        loggingInterceptor: HttpLoggingInterceptor,
        apiExceptionInterceptor: ApiExceptionInterceptor
    ): ApiClient {
        return object : ApiClient(BuildConfig.BASE_URL) {
            override fun setOkHttpClientDefaults(builder: OkHttpClient.Builder) {
                super.setOkHttpClientDefaults(builder)
                builder.apply {
                    addInterceptor(loggingInterceptor)
                    addInterceptor(authInterceptor)
                    addInterceptor(apiExceptionInterceptor)
                }
            }
        }
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    fun provideApiService(apiClient: ApiClient): ApiService {
        return apiClient.apiService()
    }
}