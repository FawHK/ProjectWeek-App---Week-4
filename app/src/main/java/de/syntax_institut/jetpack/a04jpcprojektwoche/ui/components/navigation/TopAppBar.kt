package de.syntax_institut.jetpack.a04jpcprojektwoche.ui.components.navigation

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: String,
    navIcon: ImageVector?,
    didClickNavIcon: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            if (navIcon != null) {
                IconButton(onClick = didClickNavIcon) {
                    Icon(
                        imageVector = navIcon,
                        contentDescription = "Localized description"
                    )
                }
            }
        }
    )
}
