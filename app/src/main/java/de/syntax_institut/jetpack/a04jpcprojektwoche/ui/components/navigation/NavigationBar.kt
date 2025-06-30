package de.syntax_institut.jetpack.a04jpcprojektwoche.ui.components.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import de.syntax_institut.jetpack.a04jpcprojektwoche.data.model.NavigationItems


@Composable
fun BottomNavigationBar(
    navItems: List<NavigationItems>,
    onNavSelectionChanged: (NavigationItems) -> Unit,
    selectedNavigationItem: NavigationItems
) {
    NavigationBar {
        navItems.forEach { navItem ->
            NavigationBarItem(
                selected = selectedNavigationItem == navItem,
                onClick = {
                    onNavSelectionChanged(navItem)
                },
                icon = { Icon(navItem.icon, contentDescription = null) },
                label = { Text(stringResource(navItem.label)) }
            )
        }
    }
}

