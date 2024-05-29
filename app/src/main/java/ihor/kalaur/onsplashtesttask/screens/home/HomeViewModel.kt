package ihor.kalaur.onsplashtesttask.screens.home

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import ihor.kalaur.onsplashtesttask.data.repository.Repository
import ihor.kalaur.onsplashtesttask.model.UnsplashImage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: Repository
): ViewModel() {
    val getAllImages: Flow<PagingData<UnsplashImage>> = repository.getAllImages()
}