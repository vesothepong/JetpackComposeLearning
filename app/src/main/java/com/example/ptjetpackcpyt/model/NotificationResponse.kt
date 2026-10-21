package com.example.ptjetpackcpyt.model

data class NotificationResponse(
    val notificationId: String,
    val title: String,
    val message: String,
    val type: NotificationType,
    val createdAt: String,
    val isRead: Boolean
)

enum class NotificationType {
    GENERAL,
    MESSAGE,
    SYSTEM,
    PAYMENT,
    REMINDER,
    PROMOTION
}