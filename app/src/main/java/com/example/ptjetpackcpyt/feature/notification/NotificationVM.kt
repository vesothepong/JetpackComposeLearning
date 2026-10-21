package com.example.ptjetpackcpyt.feature.notification

import androidx.lifecycle.ViewModel
import com.example.ptjetpackcpyt.model.NotificationResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NotificationVM(
    private val notificationRepository: NotificationRepository = NotificationRepository()
) : ViewModel() {
    private val _notificationList = MutableStateFlow<List<NotificationResponse>>(emptyList())
    val notificationList: StateFlow<List<NotificationResponse>> = _notificationList.asStateFlow()

    init {
        getNotificationList()
    }

    fun getNotificationList() {
        _notificationList.value = notificationRepository.getNotificationList()
    }
}