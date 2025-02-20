package kg.geeks.hw33.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun CharacterDetailScreen(navController: NavController?, character: Character) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(character.imageUrl),
            contentDescription = character.name,
            modifier = Modifier.size(400.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = character.name, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Text(text = "Status: ${character.status}", fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterDetailScreen() {
    CharacterDetailScreen(
        navController = null,
        character = Character(
            id = "1",
            name = "Rick Sanchez",
            status = "Alive",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
        )
    )
}
//https://www.google.com/url?sa=i&url=https%3A%2F%2Frickandmorty.fandom.com%2Fwiki%2FRick_Sanchez&psig=AOvVaw2wVcku20eSIbLuGysjkbCQ&ust=1740123110943000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCNjK8obe0YsDFQAAAAAdAAAAABAE