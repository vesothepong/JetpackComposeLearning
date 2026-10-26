package com.example.ptjetpackcpyt.coroutine.card

import com.example.ptjetpackcpyt.coroutine.model.CardModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.milliseconds

class cardRepository {
    private val cardList = List(100) { index ->
        CardModel(
            cardId = "CARD${index + 1}",
            title = "Card ${index + 1}",
            description = "This is the description for card ${index + 1}"
        )
    }
   suspend fun getMessage(): Flow<List<CardModel>> {
       delay(1000.milliseconds)
       return flow {
           emit(cardList)
       }
    }
}