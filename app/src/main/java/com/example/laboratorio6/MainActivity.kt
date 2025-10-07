package com.example.laboratorio6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.laboratorio6.ui.detail.PokemonDetailScreen
import com.example.laboratorio6.ui.list.PokemonListScreen
import com.example.laboratorio6.ui.theme.Laboratorio6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio6Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val nav = rememberNavController()
                    NavHost(navController = nav, startDestination = Routes.LIST) {
                        composable(Routes.LIST) {
                            PokemonListScreen(
                                onOpenDetail = { id, name -> nav.navigate(Routes.detailOf(id, name)) }
                            )
                        }
                        composable(
                            route = Routes.DETAIL,
                            arguments = listOf(
                                navArgument("id") { type = NavType.IntType },
                                navArgument("name") { type = NavType.StringType }
                            )
                        ) { backStack ->
                            val id = backStack.arguments?.getInt("id") ?: 1
                            val name = backStack.arguments?.getString("name").orEmpty()
                            PokemonDetailScreen(id = id, name = name, onBack = { nav.popBackStack() })
                        }
                    }
                }
            }
        }
    }
}
