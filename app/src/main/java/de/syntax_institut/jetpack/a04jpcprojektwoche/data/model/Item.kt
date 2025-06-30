package de.syntax_institut.jetpack.a04jpcprojektwoche.data.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val id: Long,
    @DrawableRes
    val imageRes: Int,
    val headline: String,
    val subhead: String,
    val supportingText: String,
    val description: String,
    val rating: String
) {
    var isFavorite by mutableStateOf(false)
}
