package com.example.ptjetpackcpyt.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ptjetpackcpyt.model.base.BaseUIState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class HomeVM(
    private val homeRepository: HomeRepository = HomeRepository()
) : ViewModel() {
    private val _messageUIState = MutableStateFlow<BaseUIState<List<String>>>(BaseUIState.None)
    val messageUIState: StateFlow<BaseUIState<List<String>>> = _messageUIState.asStateFlow()

    init {
        getMessage()
    }

    fun getMessage() {
        viewModelScope.launch {
            _messageUIState.value = BaseUIState.Loading
            try {
                delay(3000.milliseconds)
                _messageUIState.value = BaseUIState.Success(homeRepository.getMessage())
            } catch (e: Exception) {
                _messageUIState.value = BaseUIState.Error(
                    code = -1,
                    message = e.localizedMessage ?: "Failed to load messages"
                )
            }
        }
    }
}