package kg.geeks.hw33.ui.screen.character

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel


@Composable
fun CharactersScreen(
    onNavigateToDetail: (Int) -> Unit,
    viewModel: CharacterViewModel = koinViewModel()
) {
    val characters = viewModel.character.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.fetchAllCharacter()
    }

    LazyColumn {
        items(characters) {character ->
            CharacterItem(
                character = character,
                onItemClick = {
                    onNavigateToDetail(character.id)
                }
            )
        }
    }
}
