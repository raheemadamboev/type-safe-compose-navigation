package xyz.teamgravity.typesafecomposenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import xyz.teamgravity.typesafecomposenavigation.ui.theme.TypeSafeComposeNavigationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TypeSafeComposeNavigationTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val controller = rememberNavController()

                    NavHost(
                        navController = controller,
                        startDestination = ScreenA
                    ) {
                        composable<ScreenA> {
                            ScreenA(
                                onNavigateScreenB = { name, age ->
                                    controller.navigate(
                                        ScreenB(
                                            name = name,
                                            age = age
                                        )
                                    )
                                }
                            )
                        }
                        composable<ScreenB> { entry ->
                            ScreenB(
                                args = entry.toRoute()
                            )
                        }
                    }
                }
            }
        }
    }
}