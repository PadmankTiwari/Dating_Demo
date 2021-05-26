package com.example.aisle.ui.verify

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.aisle.BR
import com.example.aisle.R
import com.example.aisle.databinding.FragmentOtpVerifyBinding
import com.example.aisle.ui.base.BaseFragment
import com.example.aisle.utils.AppConstants
import com.example.aisle.utils.hideSoftInput
import com.example.aisle.utils.stringRes
import com.example.aisle.utils.toAppError
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtpVerifyFragment : BaseFragment<FragmentOtpVerifyBinding, OtpVerifyViewModel>() {

    private val otpVerifyViewModel: OtpVerifyViewModel by viewModels()

    private var countDownTimer: CountDownTimer? = null

    private val args: OtpVerifyFragmentArgs by navArgs()

    private var otpExpire: Boolean = true


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViewDataBinding().tvOtpVerifyHeading.text =
            getString(R.string.otp_text, args.mobileNumber)
        otpVerifyViewModel.mobileNumber.value = args.mobileNumber
        onClick()
        setTimer()
    }

    private fun onClick() {
        getViewDataBinding().clickListener = View.OnClickListener {
            hideSoftInput()
            when (it.id) {
                R.id.btnContinue -> {
                    if (isOtpValid() && otpExpire) {
                        verifyOtp()
                    } else showMessage(getString(R.string.invalid_otp))
                }
                R.id.tvOtpVerifyHeading -> {
                    findNavController().popBackStack()
                }
            }
        }
    }

    private fun verifyOtp() {
        otpVerifyViewModel.getVerifyOtp().observe(viewLifecycleOwner, { loadState ->
            showLoading(loadState.isLoading)
            loadState.getErrorIfExists().toAppError()?.let { appError ->
                showAlert(appError.stringRes())
            }
            loadState.getValueOrNull()?.let {
                findNavController().navigate(R.id.action_otpVerifyFragment_to_homeFragment)
            }
        })
    }

    private fun setTimer() {
        getViewDataBinding().tvTimer.visibility = View.VISIBLE
        countDownTimer = object : CountDownTimer(
            AppConstants.Max_Timer_Value.toLong(),
            AppConstants.Count_Donw_Interval.toLong()
        ) {
            override fun onTick(millisUntilFinished: Long) {
                getViewDataBinding().tvTimer.text = if ((millisUntilFinished / 1000) % 60 >= 10) {
                    "00:${(millisUntilFinished / 1000) % 60}"
                } else {
                    "00:0${(millisUntilFinished / 1000) % 60}"
                }
            }

            override fun onFinish() {
                getViewDataBinding().tvTimer.visibility = View.GONE
                otpExpire = false
                showAlert(getString(R.string.otp_expired))
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopTimer()
    }

    private fun stopTimer() {
        countDownTimer?.cancel()
    }

    private fun isOtpValid() = otpVerifyViewModel.otp.value?.length == 4

    override fun getLayoutId() = R.layout.fragment_otp_verify

    override fun getBindingVariable() = BR.otpVerifyViewModel

    override fun getViewModel() = otpVerifyViewModel
}