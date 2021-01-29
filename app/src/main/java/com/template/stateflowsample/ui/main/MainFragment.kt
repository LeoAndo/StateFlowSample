package com.template.stateflowsample.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.template.stateflowsample.R
import com.template.stateflowsample.observe
import com.template.stateflowsample.observeNonNull
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        observeStateFlow()
        viewModel.updateText()
    }

    private fun observeStateFlow() {
        viewModel.stateFlow.observeNonNull(viewLifecycleOwner) {
            Log.d("stateFLow observeNonNull", "result: $it")
        }
        viewModel.stateFlow.observe(viewLifecycleOwner) {
            Log.d("stateFLow observe", "result: $it")
        }
    }
}