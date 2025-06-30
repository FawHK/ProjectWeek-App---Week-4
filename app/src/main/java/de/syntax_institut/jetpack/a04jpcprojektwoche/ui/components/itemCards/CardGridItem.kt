package de.syntax_institut.jetpack.a04jpcprojektwoche.ui.components.itemCards

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.components.itemCards.favoriteIcon.FavoriteIcon


@Composable
fun CardGridItem(
    @DrawableRes
    imageRes: Int,
    headline: String,
    supportingText: String,
    rating: String,
    isFavorite: Boolean,
    onClick: () -> Unit ,
    onFavoriteClick: () -> Unit ,
) {
    ElevatedCard(
        Modifier
            .width(240.dp)
            .clickable { onClick() }
    ) {
        val textModifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        Column {
            Box(
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painterResource(imageRes),
                    headline,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                FavoriteIcon(isFavorite, onFavoriteClick)
            }
            Text(
                headline,
                textModifier,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 18.sp
            )
            Text(
                supportingText,
                textModifier,
                maxLines = 3,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                rating,
                textModifier,
                maxLines = 1,
                color = MaterialTheme.colorScheme.outline,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 14.sp
            )
        }
    }
}

