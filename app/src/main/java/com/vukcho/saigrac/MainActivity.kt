package com.vukcho.saigrac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.vukcho.saigrac.navigation.AppNavigation
import com.vukcho.saigrac.navigation.NavigationManager
import com.vukcho.saigrac.ui.theme.SaigracTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SaigracTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(
                        navController = rememberNavController(),
                        navigationManager = navigationManager,
                        innerPadding = innerPadding,
                        modifier = Modifier,
                    )
                }
            }
        }
    }
}
