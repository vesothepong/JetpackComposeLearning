package com.example.ptjetpackcpyt.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.ptjetpackcpyt.feature.home.ScreenHome
import com.example.ptjetpackcpyt.feature.notification.ScreenNotification

data object Home

data object Notification
@Composable
fun AppNavigation() {

    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack,
        onBack = {
            if (backStack.size > 1) {
                backStack.removeLastOrNull()
            }
        },
        entryProvider = { key ->
            when (key) {
                is Home -> NavEntry(key) {
                    ScreenHome(
                        onNavigateToNotification = {
                            backStack.add(Notification)
                        }
                    )
                }
                is Notification -> NavEntry(key) {
                    ScreenNotification(
                        onBackClick = {
                            if (backStack.size > 1) {
                                backStack.removeLastOrNull()
                            }
                        }
                    )
                }
                else -> NavEntry(Unit) { Text("Unknown route") }
            }
        }
    )
}