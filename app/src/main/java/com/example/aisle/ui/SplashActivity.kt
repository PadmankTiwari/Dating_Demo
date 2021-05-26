package com.example.aisle.ui

import android.content.Intent
import androidx.lifecycle.lifecycleScope
import com.example.aisle.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    init {
        lifecycleScope.launchWhenResumed {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}