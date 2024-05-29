package ihor.kalaur.onsplashtesttask.screens.home

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
) {
    TopAppBar(
        modifier = Modifier.background(color = Color.DarkGray),
        title = {
            Text(
                text = "Home Page",
                color = Color.Black
            )
        }
    )
}

@Composable
@Preview
fun HomeTopBarPreview() {
    HomeTopBar()
}