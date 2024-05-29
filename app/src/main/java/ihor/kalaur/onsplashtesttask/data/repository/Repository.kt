package ihor.kalaur.onsplashtesttask.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ihor.kalaur.onsplashtesttask.data.local.UnsplashDatabase
import ihor.kalaur.onsplashtesttask.data.paging.UnsplashRemoteMediator
import ihor.kalaur.onsplashtesttask.data.remote.UnsplashApi
import ihor.kalaur.onsplashtesttask.model.UnsplashImage
import ihor.kalaur.onsplashtesttask.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
) {

    fun getAllImages() : Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { unsplashDatabase.unsplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

}