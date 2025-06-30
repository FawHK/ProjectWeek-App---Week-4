package de.syntax_institut.jetpack.a04jpcprojektwoche.ui.components.itemCards

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.components.itemCards.favoriteIcon.FavoriteIcon


@Composable
fun CardListItem(
    modifier: Modifier = Modifier,
    @DrawableRes
    imageRes: Int,
    headline: String,
    supportingText: String,
    rating: String,
    isFavorite: Boolean,
    onClick: () -> Unit ,
    onFavoriteClick: () -> Unit
) {
    ElevatedCard(
        shape = CardDefaults.elevatedShape
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            .clickable { onClick() }
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = "Image of $headline",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = headline,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1
                )
                Text(
                    text = supportingText,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = rating,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 12.sp,
                    maxLines = 1,
                    color = MaterialTheme.colorScheme.outline,
                )
            }
            FavoriteIcon(isFavorite, onFavoriteClick)
        }
        HorizontalDivider(
            color = MaterialTheme.colorScheme.outline,
            thickness = 0.dp,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
    }
}

