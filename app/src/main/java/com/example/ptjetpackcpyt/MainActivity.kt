
package com.example.ptjetpackcpyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ptjetpackcpyt.feature.home.ScreenHome
import com.example.ptjetpackcpyt.ui.theme.BaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            BaseTheme {
                ScreenHome()
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
