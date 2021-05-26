package com.example.aisle.ui.base

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.aisle.R
import com.example.aisle.utils.showLoadingDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null

    fun showMessage(stringRes: Int) {
        Snackbar.make(findViewById(R.id.clMain), stringRes, Snackbar.LENGTH_LONG).show()
    }

    fun showMessage(message: String) {
        Snackbar.make(findViewById(R.id.clMain), message, Snackbar.LENGTH_LONG).show()
    }

    fun showLoading(visible: Boolean) {
        if (visible) {
            hideLoading()
            progressDialog = showLoadingDialog(this)
        } else {
            hideLoading()
        }
    }

    fun hideLoading() {
        progressDialog?.cancel()
    }

    fun showAlert(message: String) {
            MaterialAlertDialogBuilder(this).setMessage(message).show()
    }

    fun showAlert(message: Int) {
        MaterialAlertDialogBuilder(this).setMessage(getString(message)).show()
    }
}