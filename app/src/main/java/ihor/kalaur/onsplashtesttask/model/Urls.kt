package ihor.kalaur.onsplashtesttask.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Urls(
    @SerialName("thumb")
    val smallImage: String,
    @SerialName("raw")
    val hugeImage: String
)
