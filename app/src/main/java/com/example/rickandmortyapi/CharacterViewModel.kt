package com.example.rickandmortyapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CharacterViewModel(private val repository: CharacterRepository): ViewModel() {
    private val _characters = MutableLiveData<List<GameCharacter>>()
    val characters: LiveData<List<GameCharacter>> = _characters

    fun fetchCharacters(page: Int) {
        viewModelScope.launch {
            val chars = repository.getCharacters(page)
            _characters.value = chars
        }
    }
}
