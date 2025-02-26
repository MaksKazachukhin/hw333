package kg.geeks.hw33.model

import kg.geeks.hw33.data.dto.CharacterResponse

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val image: String,
    val species: String,
    val gender: String,
    val location: String,
)

fun CharacterResponse.toCharacterModel(): CharacterModel {
    return CharacterModel(
        id = this.id,
        name = this.name,
        status = this.status,
        image = this.image,
        species = this.species,
        gender = this.gender,
        location = this.location?.name ?: "Unknown"
    )
}