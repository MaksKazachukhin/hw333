package kg.geeks.hw33.repository

import kg.geeks.hw33.data.api.CharacterApiService
import kg.geeks.hw33.data.dto.CharacterResponse
import kg.geeks.hw33.model.CharacterModel
import kg.geeks.hw33.model.toCharacterModel

class CharacterRepository(private val apiService: CharacterApiService) {
    suspend fun getAllCharacter(): List<CharacterModel> {
        val response = apiService.getAllCharacter()
        return response.characterResponses.map { it.toCharacterModel() }
    }
}