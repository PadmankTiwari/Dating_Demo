package com.example.aisle.data.session

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SessionManagerImpl @Inject constructor(
    @ApplicationContext context: Context
) : SessionManager {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    private val editor = prefs.edit()

    companion object {
        const val PREF_NAME = "user_session"
        const val USER_TOKEN = "user_token"
        const val USER_SESSION = "user_session"
    }

    override fun saveToken(token: String) {
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    override fun fetchToken(): String {
        return prefs.getString(USER_TOKEN, "").toString()
    }

    override fun saveUserSession(isLoggedIn: Boolean) {
        editor.putBoolean(USER_SESSION,isLoggedIn)
        editor.apply()
    }

    override fun fetchUserSession(): Boolean {
        return prefs.getBoolean(USER_SESSION, false)
    }
}