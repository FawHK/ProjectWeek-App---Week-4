package de.syntax_institut.jetpack.a04jpcprojektwoche.data.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import de.syntax_institut.jetpack.a04jpcprojektwoche.R

enum class NavigationItems(
    val route: Any,
    @StringRes
    val label: Int,
    val icon: ImageVector
) {
    Items(
        route = ItemListRoute,
        label = R.string.items,
        icon = Icons.Filled.GridView
    ),
    Search(
        route = SearchRoute,
        label = R.string.search,
        icon = Icons.Filled.Search
    ),
    Favorites(
        route = FavoritesRoute,
        label = R.string.favorites,
        icon = Icons.Filled.Favorite
    )
}