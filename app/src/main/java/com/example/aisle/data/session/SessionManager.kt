package com.example.aisle.data.session

interface SessionManager {

    fun saveToken(token: String)
    fun fetchToken(): String

    fun saveUserSession(isLoggedIn: Boolean)
    fun fetchUserSession(): Boolean
}