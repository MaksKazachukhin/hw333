package kg.geeks.hw33.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun CharactersScreen(navController: NavController) {
    LazyColumn {
        items(mockCharacters) { character ->
            CharacterItem(character, navController)
        }

    }
}
