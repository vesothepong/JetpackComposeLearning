
package com.example.ptjetpackcpyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ptjetpackcpyt.feature.home.ScreenHome
import com.example.ptjetpackcpyt.navigation.AppNavigation
import com.example.ptjetpackcpyt.ui.theme.BaseTheme
import com.example.ptjetpackcpyt.utils.LoadingContent
import com.example.ptjetpackcpyt.utils.LoadingUtil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            BaseTheme {
                if (LoadingUtil.isLoading.value) {
                    LoadingContent()
                }
                AppNavigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BaseTheme {
        ScreenHome()
    }
}
