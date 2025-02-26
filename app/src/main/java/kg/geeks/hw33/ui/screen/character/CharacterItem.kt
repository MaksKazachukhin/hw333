package kg.geeks.hw33.ui.screen.character

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import kg.geeks.hw33.model.CharacterModel

@Composable
fun CharacterItem(character: CharacterModel, onItemClick: (CharacterModel) -> Unit) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .clickable{ onItemClick(character)}
    ) {
        Image(
            painter = rememberAsyncImagePainter(character.image),
            contentDescription = character.name,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = character.name)
            Text(text = "Status: ${character.status}")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewCharacterItem() {
//    CharacterItem(
//        character = Character(
//            id = "1",
//            name = "Rick Sanchez",
//            status = "Alive",
//            imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
//        ),
//        navController = null // Передаем null, потому что NavController в Preview не нужен
//    )
//}
