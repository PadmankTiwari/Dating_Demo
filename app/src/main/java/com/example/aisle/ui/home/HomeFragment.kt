package com.example.aisle.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aisle.BR
import com.example.aisle.R
import com.example.aisle.data.session.SessionManager
import com.example.aisle.databinding.FragmentHomeBinding
import com.example.aisle.ui.base.BaseFragment
import com.example.aisle.utils.hideSoftInput
import com.example.aisle.utils.stringRes
import com.example.aisle.utils.toAppError
import com.example.api.model.response.ProfileX
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    private val homeViewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideSoftInput()
        getProfileList()
        onClick()
    }

    private fun onClick() {
        getViewDataBinding().clickListener = View.OnClickListener {
            when(it.id) {
                R.id.btnUpgrade -> {
                    showAlert("Upgrade")
                }
            }
        }
    }

    private fun getProfileList() {
        homeViewModel.getProfileList().observe(viewLifecycleOwner, { loadState ->
            showLoading(loadState.isLoading)
            loadState.getErrorIfExists().toAppError()?.let { appError ->
                showAlert(appError.stringRes())
            }
            loadState.getValueOrNull()?.let {
                sessionManager.saveUserSession(true)
                getViewDataBinding().productListResponse = it
                initAdapter(it.likes.profiles)
            }
        })
    }

    private fun initAdapter(profiles: List<ProfileX>) {
        val profileListAdapter = ProfileListAdapter(profile = profiles)
        getViewDataBinding().rvProfiles.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,true)
            adapter = profileListAdapter
        }
    }

    override fun getLayoutId() = R.layout.fragment_home

    override fun getBindingVariable() = BR.homeViewModel

    override fun getViewModel() = homeViewModel
}