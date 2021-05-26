package com.example.aisle.data

import android.content.Context
import android.net.ConnectivityManager
import com.example.aisle.data.session.SessionManager
import com.example.api.NoInternetConnection
import dagger.hilt.android.qualifiers.ApplicationContext

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiExceptionInterceptor @Inject constructor(
    @ApplicationContext val context: Context,
    private val sessionManager: SessionManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        if (!isConnected()) {
            throw NoInternetConnection()
        }

        val builder: Request.Builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    private fun isConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }
}