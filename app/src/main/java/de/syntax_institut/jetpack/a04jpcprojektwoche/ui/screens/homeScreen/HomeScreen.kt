package de.syntax_institut.jetpack.a04jpcprojektwoche.ui.screens.homeScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.syntax_institut.jetpack.a04jpcprojektwoche.data.Repository
import de.syntax_institut.jetpack.a04jpcprojektwoche.data.model.Item
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.screens.itemsScreens.GridListScreen
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.screens.itemsScreens.ItemListScreen


@Composable
fun HomeScreen(navController: NavController) {
    var screenState by remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.padding(top = 65.dp),
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 70.dp),
                onClick = { screenState = !screenState }
            ) {
                Icon(
                    imageVector = if (screenState) Icons.Filled.GridView else Icons.Filled.FormatListNumbered,
                    contentDescription = "Floating action button."
                )
            }
        }
    ) { innerPadding ->
        if (screenState) {
            ItemListScreen(
                Repository.items,
                modifier = Modifier.padding(innerPadding),
                onClick = {
                    navController.navigate(
                        Item(
                            imageRes = it.imageRes,
                            headline = it.headline,
                            supportingText = it.supportingText,
                            rating = it.rating,
                            description = it.description,
                            subhead = it.subhead,
                            id = it.id
                        )
                    )
                },
                onFavoriteClick = {
                    it.isFavorite = !it.isFavorite
                }
            )
        } else {
            GridListScreen(
                Repository.items,
                modifier = Modifier.padding(innerPadding),
                onClick = {
                    navController.navigate(
                        Item(
                            imageRes = it.imageRes,
                            headline = it.headline,
                            supportingText = it.supportingText,
                            rating = it.rating,
                            description = it.description,
                            subhead = it.subhead,
                            id = it.id
                        )
                    )
                },
                onFavoriteClick = {
                    it.isFavorite = !it.isFavorite
                }
            )
        }
    }
}




