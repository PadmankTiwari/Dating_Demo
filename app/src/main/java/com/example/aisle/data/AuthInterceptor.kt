package com.example.aisle.data

import android.content.Context
import com.example.aisle.data.session.SessionManager
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(
    @ApplicationContext val context: Context,
    private val sessionManager: SessionManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        requestBuilder.addHeader("Content-Type", "application/json")
        // If token has been saved, add it to the request
        val token = sessionManager.fetchToken()
        if (token.isEmpty().not()) {
            requestBuilder.addHeader("Authorization", "$token")
        }

        return chain.proceed(requestBuilder.build())
    }
}