package de.syntax_institut.jetpack.a04jpcprojektwoche.ui.screens.itemDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ItemDetailScreen(
    imageRes: Int,
    headline: String,
    subhead: String,
    supportingText: String,
    description: String,
    rating: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(bottom = 16.dp)
            .verticalScroll(
                state = rememberScrollState()
            ),
    ) {
        Box(
            contentAlignment = Alignment.TopEnd
        ) {
            Image(
                painterResource(imageRes),
                headline,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
            )
        }
        Text(
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp).fillMaxWidth(),
            text = headline,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            lineHeight = 30.sp,
        )
        Spacer(Modifier.padding(top = 8.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = subhead,
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Start,
            fontSize = 18.sp
        )
        Spacer(Modifier.padding(top = 8.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = supportingText,
            style = MaterialTheme.typography.labelMedium,
            fontSize = 14.sp,
        )
        Spacer(Modifier.padding(top = 16.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = rating,
            style = MaterialTheme.typography.labelMedium,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.outline
        )
        Spacer(Modifier.padding(top = 16.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 14.sp,
        )
    }
//    }
}



