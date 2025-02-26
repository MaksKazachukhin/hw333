package kg.geeks.hw33.ui.screen.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.geeks.hw33.model.CharacterModel
import kg.geeks.hw33.model.toCharacterModel
import kg.geeks.hw33.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(private val repository: CharacterRepository) : ViewModel() {
    private val _character = MutableStateFlow<List<CharacterModel>>(emptyList())
    val character: StateFlow<List<CharacterModel>> = _character

    fun fetchAllCharacter() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _character.value = repository.getAllCharacter()
            } catch (e: Exception) {
                _character.value = emptyList()
            }
        }
    }
}