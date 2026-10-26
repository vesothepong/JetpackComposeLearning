package com.example.ptjetpackcpyt.coroutine.card

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.BaseViewModel
import com.example.ptjetpackcpyt.coroutine.model.CardModel
import com.example.ptjetpackcpyt.model.base.BaseUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class cardVM(
    private val CardRepository: cardRepository = cardRepository()
) : BaseViewModel() {
    private var _cardListUiState : MutableStateFlow<BaseUIState<List<CardModel>>> =
        MutableStateFlow(BaseUIState.None)
    var cardListUiState = _cardListUiState.asStateFlow()

    fun getCardList(){
        viewModelScope.launch {
            _cardListUiState.emit(BaseUIState.Loading)
            CardRepository.getMessage().collect { data->
                _cardListUiState.emit(BaseUIState.Success(data))
            }
        }
    }
    init{
        getCardList()
    }
}