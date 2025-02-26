package kg.geeks.hw33.data.api

import kg.geeks.hw33.data.dto.CharaResultResponse
import kg.geeks.hw33.data.dto.CharacterResponse
import retrofit2.http.GET

interface CharacterApiService {

    @GET("character")
    suspend fun getAllCharacter(): CharaResultResponse
}