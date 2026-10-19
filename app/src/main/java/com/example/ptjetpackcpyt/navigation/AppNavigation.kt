package com.example.ptjetpackcpyt.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.ptjetpackcpyt.feature.home.ScreenHome

data object Home
@Composable
fun AppNavigation() {

    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is Home -> NavEntry(key) {
                    ScreenHome()
                }
                else -> NavEntry(Unit) { Text("Unknown route") }
            }
        }
    )
}