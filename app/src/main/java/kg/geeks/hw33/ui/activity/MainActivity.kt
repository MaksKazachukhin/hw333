package kg.geeks.hw33.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import kg.geeks.hw33.nav.BottomNavigationBar
import kg.geeks.hw33.ui.*
import kg.geeks.hw33.ui.screen.character.CharacterViewModel
import kg.geeks.hw33.ui.screen.character.detail.CharacterDetailScreen
import kg.geeks.hw33.ui.screen.character.CharactersScreen
import kg.geeks.hw33.ui.screen.location.LocationScreen
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApp()
        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun MyComposeApp() {
    val navController = rememberNavController()
    val currentRoute = getCurrentRoute(navController)

    val characterViewModel: CharacterViewModel = koinViewModel()

    Scaffold(
        bottomBar = {
            if (currentRoute !in listOf("characterDetail")) {
                BottomNavigationBar(navController)
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,

            startDestination = "characters",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("characters") {
                CharactersScreen(
                    onNavigateToDetail = { characterId ->
                        navController.navigate("characterDetail/$characterId")
                    },
                    viewModel = characterViewModel
                )
            }

            composable("locations") {
                LocationScreen(navController)
            }
            composable("characterDetail/{characterId}") { backStackEntry ->
                val characterId = backStackEntry.arguments?.getString("characterId")?.toInt() ?: 0
                val character =
                    characterViewModel.character.value.firstOrNull() { it.id == characterId }
                if (character != null) {
                    CharacterDetailScreen(
                        character = character,
                       onBackClick = {navController.popBackStack()}
                    )
                } else {
                    Text("Персонаж не найден")
                }
            }
        }
    }
}

@Composable
fun getCurrentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}
