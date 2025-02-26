package kg.geeks.hw33.nav

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn

@Composable
fun BottomNavigationBar(navController: NavController) {
    val selectedItem = remember { mutableStateOf("characters") }

    NavigationBar {
        NavigationBarItem(
            selected = selectedItem.value == "characters",
            onClick = {
                selectedItem.value = "characters"
                navController.navigate("characters")
            },
            icon = { Icon(Icons.Default.List, contentDescription = "Characters") },
            label = { Text("Characters") }
        )
        NavigationBarItem(
            selected = selectedItem.value == "locations",
            onClick = {
                selectedItem.value = "locations"
                navController.navigate("locations")
            },
            icon = { Icon(Icons.Default.LocationOn, contentDescription = "Locations") },
            label = { Text("Locations") }
        )
        NavigationBarItem(
            selected = selectedItem.value == "episodes",
            onClick = {
                selectedItem.value = "episodes"
                navController.navigate("episodes")
            },
            icon = { Icon(Icons.Default.LocationOn, contentDescription = "Episodes")},

            label = { Text("Episodes") }
        )
    }
}
