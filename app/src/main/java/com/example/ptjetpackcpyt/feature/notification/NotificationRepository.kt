package com.example.ptjetpackcpyt.feature.notification

import com.example.ptjetpackcpyt.model.NotificationResponse
import com.example.ptjetpackcpyt.model.NotificationType

class NotificationRepository {
    private val notificationList = listOf(
            NotificationResponse(
                "N001",
                "Welcome!",
                "Welcome to our application. Enjoy using our services.",
                NotificationType.GENERAL,
                "2026-10-19 08:00",
                false
            ),
            NotificationResponse(
                "N002",
                "New Message",
                "You have received a new message from Sokha.",
                NotificationType.MESSAGE,
                "2026-10-19 08:15",
                false
            ),
            NotificationResponse(
                "N003",
                "System Update",
                "A new version of the application is available.",
                NotificationType.SYSTEM,
                "2026-10-19 08:30",
                true
            ),
            NotificationResponse(
                "N004",
                "Payment Successful",
                "Your payment of $25.00 was successful.",
                NotificationType.PAYMENT,
                "2026-10-19 09:00",
                false
            ),
            NotificationResponse(
                "N005",
                "Study Reminder",
                "Remember to review your Kotlin lessons today.",
                NotificationType.REMINDER,
                "2026-10-19 09:30",
                false
            ),
            NotificationResponse(
                "N006",
                "Special Offer",
                "Get 20% off selected products this week.",
                NotificationType.PROMOTION,
                "2026-10-19 10:00",
                true
            ),
            NotificationResponse(
                "N007",
                "New Message",
                "Dara sent you a message.",
                NotificationType.MESSAGE,
                "2026-10-19 10:15",
                false
            ),
            NotificationResponse(
                "N008",
                "Account Security",
                "Your account security settings were updated.",
                NotificationType.SYSTEM,
                "2026-10-19 10:30",
                true
            ),
            NotificationResponse(
                "N009",
                "Payment Reminder",
                "Your monthly subscription payment is due soon.",
                NotificationType.PAYMENT,
                "2026-10-19 11:00",
                false
            ),
            NotificationResponse(
                "N010",
                "Assignment Reminder",
                "Your Android development assignment is due tomorrow.",
                NotificationType.REMINDER,
                "2026-10-19 11:30",
                false
            ),
            NotificationResponse(
                "N011",
                "Congratulations!",
                "You have completed your learning goal for this week.",
                NotificationType.GENERAL,
                "2026-10-19 12:00",
                true
            ),
            NotificationResponse(
                "N012",
                "New Message",
                "Your project teammate sent you a message.",
                NotificationType.MESSAGE,
                "2026-10-19 12:15",
                false
            ),
            NotificationResponse(
                "N013",
                "Maintenance Notice",
                "The application will undergo maintenance tonight.",
                NotificationType.SYSTEM,
                "2026-10-19 13:00",
                false
            ),
            NotificationResponse(
                "N014",
                "Payment Received",
                "Your payment has been confirmed.",
                NotificationType.PAYMENT,
                "2026-10-19 13:30",
                true
            ),
            NotificationResponse(
                "N015",
                "Class Reminder",
                "Your programming class starts in 30 minutes.",
                NotificationType.REMINDER,
                "2026-10-19 14:00",
                false
            ),
            NotificationResponse(
                "N016",
                "Weekend Promotion",
                "Check out our latest offers for this weekend.",
                NotificationType.PROMOTION,
                "2026-10-19 14:30",
                false
            ),
            NotificationResponse(
                "N017",
                "Profile Updated",
                "Your profile information was updated successfully.",
                NotificationType.GENERAL,
                "2026-10-19 15:00",
                true
            ),
            NotificationResponse(
                "N018",
                "New Message",
                "You have a new message from your instructor.",
                NotificationType.MESSAGE,
                "2026-10-19 15:30",
                false
            ),
            NotificationResponse(
                "N019",
                "App Update",
                "New features and improvements are ready to explore.",
                NotificationType.SYSTEM,
                "2026-10-19 16:00",
                false
            ),
            NotificationResponse(
                "N020",
                "Daily Reminder",
                "Keep learning and make progress toward your goals!",
                NotificationType.REMINDER,
                "2026-10-19 16:30",
                true
            )
        )

    fun getNotificationList():List<NotificationResponse>{
        return notificationList
    }
}