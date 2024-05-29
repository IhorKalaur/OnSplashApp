package ihor.kalaur.onsplashtesttask.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Author(
    @SerialName("username")
    val userName: String
)