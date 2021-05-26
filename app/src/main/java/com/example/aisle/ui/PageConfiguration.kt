package com.example.aisle.ui

import androidx.annotation.IdRes
import com.example.aisle.R

enum class PageConfiguration(
    val id: Int,
    val bottomNavigationBarVisible: Boolean = false
) {
    HOME(
        R.id.homeFragment,
        bottomNavigationBarVisible = true
    ),
    OTP(
        R.id.otpFragment,
        bottomNavigationBarVisible = false
    ),
    OTP_VERIFY(
        R.id.otpVerifyFragment,
        bottomNavigationBarVisible = false
    ),
    SPLASH(
        R.id.splashFragment,
        bottomNavigationBarVisible = false
    ),
    OTHER(0);

    operator fun component1() = id
    operator fun component3() = bottomNavigationBarVisible

    companion object {
        fun getConfiguration(@IdRes id: Int): PageConfiguration {
            return values()
                .firstOrNull { it.id == id } ?: OTHER
        }
    }
}
