package com.template.stateflowsample

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
inline fun <T> StateFlow<T>.observeNonNull(
    owner: LifecycleOwner,
    crossinline onChange: (T) -> Unit
) {
    owner.lifecycleScope.launchWhenStarted {
        this@observeNonNull.collect {
            if (it == null) return@collect
            onChange(it)
        }
    }
}

@ExperimentalCoroutinesApi
inline fun <T> StateFlow<T>.observe(owner: LifecycleOwner, crossinline onChange: (T) -> Unit) {
    owner.lifecycleScope.launchWhenStarted {
        this@observe.collect {
            onChange(it)
        }
    }
}