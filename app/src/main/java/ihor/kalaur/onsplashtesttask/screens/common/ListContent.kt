package ihor.kalaur.onsplashtesttask.screens.common

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import ihor.kalaur.onsplashtesttask.R
import ihor.kalaur.onsplashtesttask.model.Author
import ihor.kalaur.onsplashtesttask.model.UnsplashImage
import ihor.kalaur.onsplashtesttask.model.Urls
import ihor.kalaur.onsplashtesttask.navigation.Screen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@ExperimentalCoilApi
@Composable
fun ListContent(items: LazyPagingItems<UnsplashImage>, navController: NavController) {
    Log.d("Error", items.loadState.toString())
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items.itemCount) { index ->
            items[index]?.let { unsplashImage ->
                UnsplashItem(
                    unsplashImage = unsplashImage,
                    navController = navController
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun UnsplashItem(unsplashImage: UnsplashImage, navController: NavController) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(unsplashImage.urls.smallImage)
            .crossfade(durationMillis = 1000)
            .error(R.drawable.ic_placeholder)
            .placeholder(R.drawable.ic_placeholder)
            .build()
    )
    Box(
        modifier = Modifier
            .clickable
            {
                val url = unsplashImage.urls.hugeImage
                val encode = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
                navController.navigate("${Screen.BigPhoto.route}/$encode")
            }
            .height(300.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painter,
            contentDescription = "UnsplashImage",
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .alpha(0.5f),
            color = Color.Black
        ) { }
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                        append(unsplashImage.name)
                    }
                    append(" photo by ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                        append(unsplashImage.author.userName)
                    }
                },
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}

@ExperimentalCoilApi
@Composable
@Preview
fun UnsplashItemPreview() {
    val demoNavController = rememberNavController()
    val demoImage = UnsplashImage(
        id = "demoId",
        name = "Demo Image",
        urls = Urls(
            smallImage = "https://example.com/150",
            hugeImage = "https://example.com/1080"
        ),
        author = Author("Demo Author")
    )
    UnsplashItem(unsplashImage = demoImage, navController = demoNavController)
}
