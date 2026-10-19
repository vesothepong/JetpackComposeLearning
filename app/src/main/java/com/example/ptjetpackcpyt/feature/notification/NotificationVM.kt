package com.example.ptjetpackcpyt.feature.notification

import androidx.lifecycle.ViewModel
import com.example.ptjetpackcpyt.model.NotificationResponse
import kotlinx.coroutines.flow.MutableStateFlow

class NotificationVM(
    private val notificationRepository: NotificationRepository = NotificationRepository()
) : ViewModel(){
    private var _notificaionList: MutableStateFlow<List<NotificationResponse>> = MutableStateFlow(emptyList())
    var notificationList = _notificaionList
    fun getNotificationList(){
        _notificaionList.value = notificationRepository.getNotificationList()
    }


}