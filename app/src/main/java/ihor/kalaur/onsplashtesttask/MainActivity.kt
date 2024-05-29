package ihor.kalaur.onsplashtesttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import dagger.hilt.android.AndroidEntryPoint
import ihor.kalaur.onsplashtesttask.navigation.SetupNavGraph
import ihor.kalaur.onsplashtesttask.ui.theme.OnSplashTestTaskTheme

@OptIn(ExperimentalPagingApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnSplashTestTaskTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}
