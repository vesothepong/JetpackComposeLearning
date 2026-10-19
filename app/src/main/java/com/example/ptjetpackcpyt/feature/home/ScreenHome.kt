
package com.example.ptjetpackcpyt.feature.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ptjetpackcpyt.ui.theme.BaseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHome() {

    val homeVM = HomeVM()
    val message by homeVM.message.collectAsStateWithLifecycle()


    Scaffold(
        modifier = Modifier
            .navigationBarsPadding(),
        topBar = {
            TopAppBar(
                title = {
                    Text("My App")
                }
            )
        },
        bottomBar = {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    //das
                },
            ){
                Text("Get Message")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            item {
                Text(message)
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
