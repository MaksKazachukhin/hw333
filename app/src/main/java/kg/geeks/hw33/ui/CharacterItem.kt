package kg.geeks.hw33.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun CharacterItem(character: Character, navController: NavController?) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(character.imageUrl),
            contentDescription = character.name,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = character.name)
            Text(text = "Status: ${character.status}")
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            navController?.navigate("characterDetail/${character.id}")
        }) {
            Text("Details")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterItem() {
    CharacterItem(
        character = Character(
            id = "1",
            name = "Rick Sanchez",
            status = "Alive",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
        ),
        navController = null // Передаем null, потому что NavController в Preview не нужен
    )
}
