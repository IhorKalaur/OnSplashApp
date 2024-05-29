package ihor.kalaur.onsplashtesttask.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ihor.kalaur.onsplashtesttask.util.Constants.UNSPLASH_IMAGE_TABLE
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = UNSPLASH_IMAGE_TABLE)
data class UnsplashImage(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @SerialName("slug")
    val name: String,
    @Embedded
    val urls: Urls,
    @Embedded
    @SerialName("user")
    val author: Author
)