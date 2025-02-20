package kg.geeks.hw33.ui

import android.location.Location
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun LocationScreen (navController: NavController) {
    LazyColumn {
        items(mockCharacters) { character ->
            CharacterItem(character, navController)
        }

    }
}
