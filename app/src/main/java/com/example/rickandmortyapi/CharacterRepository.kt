package com.example.rickandmortyapi

class CharacterRepository(private val api: RickAndMortyApi) {
    suspend fun getCharacters(page: Int): List<GameCharacter>? {
        val response = api.getCharacters(page)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}
