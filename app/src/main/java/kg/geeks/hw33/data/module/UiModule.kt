package kg.geeks.hw33.data.module

import kg.geeks.hw33.ui.screen.character.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { CharacterViewModel(get()) }
}