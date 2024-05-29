package ihor.kalaur.onsplashtesttask.data.remote

import ihor.kalaur.onsplashtesttask.BuildConfig
import ihor.kalaur.onsplashtesttask.model.UnsplashImage
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    @Headers("Authorization: Client-ID ${BuildConfig.ON_SPLASH_API_KEY}")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<UnsplashImage>
}