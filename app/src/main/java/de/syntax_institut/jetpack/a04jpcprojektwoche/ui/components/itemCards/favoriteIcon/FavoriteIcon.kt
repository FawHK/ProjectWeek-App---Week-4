package de.syntax_institut.jetpack.a04jpcprojektwoche.ui.components.itemCards.favoriteIcon

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun FavoriteIcon(isFavorite: Boolean, onFavoriteClick: () -> Unit) {
    val favoriteIcon = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder
    IconButton(
        onClick = { onFavoriteClick() }
    ) {
        Icon(
            imageVector = favoriteIcon,
            contentDescription = favoriteIcon.name,
            modifier = Modifier.size(30.dp),
            tint = Color.Red
        )
    }
}