package com.example.ptjetpackcpyt.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ptjetpackcpyt.coroutine.card.CardScreenView
import com.example.ptjetpackcpyt.model.base.BaseUIState
import com.example.ptjetpackcpyt.ui.theme.BaseTheme
import com.example.ptjetpackcpyt.utils.LoadingUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHome(
    onNavigateToNotification: () -> Unit = {},
    onNavigateToCards: () -> Unit ={},
    homeVM: HomeVM = viewModel()
) {
    val messageUIState by homeVM.messageUIState.collectAsStateWithLifecycle()

    DisposableEffect(Unit) {
        onDispose {
            LoadingUtil.hideLoading()
        }
    }

    LaunchedEffect(messageUIState) {
        when (val state = messageUIState) {
            is BaseUIState.Loading -> LoadingUtil.showLoading()
            is BaseUIState.Error -> {
                LoadingUtil.hideLoading()
                println("Error : ${state.message}")
            }
            is BaseUIState.ErrorException -> {
                LoadingUtil.hideLoading()
                println("ErrorException : ${state.message}")
            }
            is BaseUIState.Success -> LoadingUtil.hideLoading()
            is BaseUIState.None -> LoadingUtil.hideLoading()
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("My App")
                },
                actions = {
                    IconButton(onClick = onNavigateToNotification) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications"
                        )
                    }
                }
            )
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                tonalElevation = 3.dp
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                        .navigationBarsPadding(),
                    onClick = {
                        homeVM.getMessage()
                    }
                ) {
                    Text("Get Message")
                }
            }
        }
    ) { paddingValues ->
        when (val state = messageUIState) {

            is BaseUIState.Success -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    Button(
                        onClick = onNavigateToCards,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text("View Cards")
                    }

                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(state.data.size) { index ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp)
                                    .padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = state.data[index],
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }

                            HorizontalDivider()
                        }
                    }
                }
            }

            is BaseUIState.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Error: ${state.message}",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            is BaseUIState.ErrorException -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Error: ${state.message}",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            is BaseUIState.None -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No messages available",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            is BaseUIState.Loading -> {
                // Loading dialog handled by LoadingUtil
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenHomePreview() {
    BaseTheme {
        ScreenHome()

    }
}

