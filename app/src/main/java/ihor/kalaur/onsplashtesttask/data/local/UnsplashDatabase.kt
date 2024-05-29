package ihor.kalaur.onsplashtesttask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ihor.kalaur.onsplashtesttask.data.local.dao.UnsplashImageDao
import ihor.kalaur.onsplashtesttask.data.local.dao.UnsplashRemoteKeysDao
import ihor.kalaur.onsplashtesttask.model.UnsplashImage
import ihor.kalaur.onsplashtesttask.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase: RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}