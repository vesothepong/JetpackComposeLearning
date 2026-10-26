package com.example.ptjetpackcpyt.coroutine.card

import com.example.ptjetpackcpyt.coroutine.model.CardModel
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class cardRepository {
    private val cardList = List(100) { index ->
        CardModel(
            cardId = "CARD${index + 1}",
            title = "Card ${index + 1}",
            description = "This is the description for card ${index + 1}"
        )
    }
   suspend fun getMessage():List<CardModel>{
       delay(1000.milliseconds)
       return cardList
    }
}