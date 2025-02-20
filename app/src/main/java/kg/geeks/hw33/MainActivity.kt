package kg.geeks.hw33

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
import kg.geeks.hw33.ui.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApp()
        }
    }
}

@Composable
fun MyComposeApp() {
    val navController = rememberNavController()
    val currentRoute = getCurrentRoute(navController)

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
                CharactersScreen(navController)
            }

            composable("locations") {
                LocationScreen(navController)
            }
            composable(
                "characterDetail/{characterId}",
                arguments = listOf(navArgument("characterId") { type = NavType.StringType })
            ) { backStackEntry ->
                val characterId = backStackEntry.arguments?.getString("characterId")
                val character = mockCharacters.find { it.id == characterId }
                if (character != null) {
                    CharacterDetailScreen(navController, character)
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
