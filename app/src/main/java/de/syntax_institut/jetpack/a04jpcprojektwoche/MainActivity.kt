package de.syntax_institut.jetpack.a04jpcprojektwoche

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.App
import de.syntax_institut.jetpack.a04jpcprojektwoche.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                App()
            }
        }
    }
}
