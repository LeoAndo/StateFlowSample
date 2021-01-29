package com.template.stateflowsample.ui.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
class MainViewModel : ViewModel() {
    private val _stateFlow = MutableStateFlow<String?>(null)
    val stateFlow: StateFlow<String?> = _stateFlow

    fun updateText() {
        // MutableStateFlow の場合は、メインスレッド・バックグラウンドスレッド関係なく value = xxx を使う。
        _stateFlow.value = "Hello, State Flow."
    }
}