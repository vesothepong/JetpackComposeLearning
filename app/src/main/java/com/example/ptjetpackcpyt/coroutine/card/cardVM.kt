package com.example.ptjetpackcpyt.coroutine.card

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ptjetpackcpyt.coroutine.model.CardModel
import com.example.ptjetpackcpyt.model.base.BaseUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class cardVM(
    private val CardRepository: cardRepository = cardRepository()
) : ViewModel() {
    private var _cardListUiState : MutableStateFlow<BaseUIState<List<CardModel>>> =
        MutableStateFlow(BaseUIState.None)
    var cardListUiState = _cardListUiState.asStateFlow()

    fun getCardList(){
        viewModelScope.launch {
            _cardListUiState.emit(BaseUIState.Loading)
            _cardListUiState.emit(BaseUIState.Success (CardRepository.getMessage()))
        }
    }
    init{
        getCardList()
    }
}