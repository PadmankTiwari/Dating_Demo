package com.example.aisle.ui.otp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.aisle.BR
import com.example.aisle.R
import com.example.aisle.databinding.FragmentOtpBinding
import com.example.aisle.ui.base.BaseFragment
import com.example.aisle.utils.hideSoftInput
import com.example.aisle.utils.stringRes
import com.example.aisle.utils.toAppError
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtpFragment : BaseFragment<FragmentOtpBinding, OtpViewModel>() {

    private val otpViewModel: OtpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick() {
        getViewDataBinding().clickListener = View.OnClickListener {
            hideSoftInput()
            when (it.id) {
                R.id.btnContinue -> {
                    if (isMobileValid()) {
                        getOtp()
                    } else showMessage(getString(R.string.invalid_mobile_number))
                }
            }
        }
    }

    private fun getOtp() {
        otpViewModel.getOtp().observe(viewLifecycleOwner, { loadState ->
            showLoading(loadState.isLoading)
            loadState.getErrorIfExists().toAppError()?.let { appError ->
                showAlert(appError.stringRes())
            }
            loadState.getValueOrNull()?.let { response ->
                if (response.status) {
                    findNavController().navigate(
                        OtpFragmentDirections.actionOtpFragmentToOtpVerifyFragment(
                            otpViewModel.mobileNumber.value.toString()
                        )
                    )
                } else {
                    showMessage(getString(R.string.something_went_wrong_error))
                }
            }

        })
    }

    private fun isMobileValid() = otpViewModel.mobileNumber.value?.length == 10

    override fun getLayoutId() = R.layout.fragment_otp

    override fun getBindingVariable() = BR.otpViewModel

    override fun getViewModel() = otpViewModel
}