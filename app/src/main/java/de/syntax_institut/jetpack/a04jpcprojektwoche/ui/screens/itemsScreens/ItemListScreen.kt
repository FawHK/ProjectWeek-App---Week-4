package de.syntax_institut.jetpack.a04jpcprojektwoche.ui.screens.itemsScreens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import de.syntax_institut.jetpack.a04jpcprojektwoche.data.model.Item
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.components.itemCards.CardListItem
import androidx.compose.ui.Modifier


@Composable
fun ItemListScreen(
    items: List<Item>,
    modifier: Modifier = Modifier,
    onClick: (Item) -> Unit = {},
    onFavoriteClick: (Item) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items) { item ->
            CardListItem(
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