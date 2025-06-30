package de.syntax_institut.jetpack.a04jpcprojektwoche.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import de.syntax_institut.jetpack.a04jpcprojektwoche.data.Repository
import de.syntax_institut.jetpack.a04jpcprojektwoche.data.model.FavoritesRoute
import de.syntax_institut.jetpack.a04jpcprojektwoche.data.model.Item
import de.syntax_institut.jetpack.a04jpcprojektwoche.data.model.ItemListRoute
import de.syntax_institut.jetpack.a04jpcprojektwoche.data.model.NavigationItems
import de.syntax_institut.jetpack.a04jpcprojektwoche.data.model.SearchRoute
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.components.navigation.BottomNavigationBar
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.components.navigation.TopAppBar
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.screens.homeScreen.HomeScreen
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.screens.itemDetail.ItemDetailScreen
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.screens.itemsScreens.GridListScreen
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.screens.itemsScreens.ItemListScreen


@Composable
fun App() {
    var selectedNavigationItem by remember { mutableStateOf(NavigationItems.Items) }
    var topBarNavItem by rememberSaveable { mutableStateOf<ImageVector?>(null) }
    val navController = rememberNavController()

    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination

    val showBottomBar = currentDestination?.hierarchy?.any { it.hasRoute(Item::class) } == false

    navController.addOnDestinationChangedListener { _, destination, _ ->
        if (destination.hierarchy.any { it.hasRoute(selectedNavigationItem.route::class) }) {
            topBarNavItem = null
        } else {
            topBarNavItem = Icons.Default.ArrowBackIosNew
        }
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = stringResource(selectedNavigationItem.label),
                navIcon = topBarNavItem
            ) {
                navController.navigateUp()
            }
        },
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(
                    NavigationItems.entries,
                    onNavSelectionChanged = { navItem ->
                        selectedNavigationItem = navItem

                    },
                    selectedNavigationItem = selectedNavigationItem
                )
            }
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = selectedNavigationItem.route
        ) {
            composable<ItemListRoute> {
                HomeScreen(navController)
            }

            composable<SearchRoute> {
                GridListScreen(
                    Repository.items.filter { it.isFavorite },
                    modifier = Modifier.padding(contentPadding),
                    onClick = {
                        navController.navigate(it)
                    },
                    onFavoriteClick = {
                        it.isFavorite = !it.isFavorite
                    }
                )
            }

            composable<FavoritesRoute> {
                ItemListScreen(
                    Repository.items.filter { it.isFavorite },
                    modifier = Modifier.padding(contentPadding),
                    onClick = {
                        navController.navigate(it)
                    },
                    onFavoriteClick = {
                        it.isFavorite = !it.isFavorite

                    }
                )
            }

            composable<Item> { backStackEntry ->
                val selectedItem = backStackEntry.toRoute<Item>()
                ItemDetailScreen(
                    imageRes = selectedItem.imageRes,
                    headline = selectedItem.headline,
                    subhead = selectedItem.subhead,
                    supportingText = selectedItem.supportingText,
                    description = selectedItem.description,
                    rating = selectedItem.rating,
                    modifier = Modifier.padding(contentPadding),
                )
            }
        }
    }
}


