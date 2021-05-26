package com.example.aisle.utils

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.core.content.getSystemService

/**
 * Used to Hide Keyboard
 */
fun Activity.hideSoftInput() {
    val imm: InputMethodManager? = getSystemService()
    val currentFocus = currentFocus
    if (currentFocus != null && imm != null) {
        imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
    }
}

/**
 * Used to Hide Keyboard
 */
fun Fragment.hideSoftInput() = requireActivity().hideSoftInput()