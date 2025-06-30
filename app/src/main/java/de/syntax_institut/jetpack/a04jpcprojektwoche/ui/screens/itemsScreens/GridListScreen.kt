package de.syntax_institut.jetpack.a04jpcprojektwoche.ui.screens.itemsScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.syntax_institut.jetpack.a04jpcprojektwoche.data.model.Item
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.components.itemCards.CardGridItem


@Composable
fun GridListScreen(
    items: List<Item>,
    modifier: Modifier = Modifier,
    onClick: (Item) -> Unit = {},
    onFavoriteClick: (Item) -> Unit = {}
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = modifier.padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 8.dp,
    ) {
        items(items) { item ->
            CardGridItem(
                imageRes = item.imageRes,
                headline = item.headline,
                supportingText = item.supportingText,
                rating = item.rating,
                isFavorite = item.isFavorite,
                onClick = { onClick(item) },
                onFavoriteClick = { onFavoriteClick(item) }
            )
        }
    }
}