package ihor.kalaur.onsplashtesttask.navigation

sealed class Screen(val route: String) {

    data object Home: Screen("home_screen")

    data object BigPhoto: Screen("big_photo")
}
