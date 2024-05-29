package ihor.kalaur.onsplashtesttask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import ihor.kalaur.onsplashtesttask.screens.bigPhoto.BigPhotoScreen
import ihor.kalaur.onsplashtesttask.screens.home.HomeScreen

@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(route = "${Screen.BigPhoto.route}/{hugeImage}",
            arguments = listOf(navArgument("hugeImage") { type = NavType.StringType})
            ){ backStackEntry ->
            val urlBigPhoto = backStackEntry.arguments?.getString("hugeImage") ?: "https://images.unsplash.com/photo-1682685797828-d3b2561deef4?ixid=M3w1NDIyMzl8MXwxfGFsbHwxfHx8fHx8Mnx8MTcwMzIwNTg0NXw&ixlib=rb-4.0.3"
            BigPhotoScreen(urlBigPhoto = urlBigPhoto)
        }
    }
}