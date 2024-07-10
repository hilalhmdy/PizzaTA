package com.example.pizzata.ui.screen.menu.detailmenu

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzata.model.Menu
import com.example.pizzata.model.News
import com.example.pizzata.ui.common.UiState
import com.example.trashure.data.repository.PizzaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailMenuViewModel (
    private val repository: PizzaRepository
) : ViewModel() {

    private val _menuState: MutableStateFlow<UiState<Menu>> =
        MutableStateFlow(UiState.Loading)

    val menuState: StateFlow<UiState<Menu>>
        get() = _menuState

    val detailMenuUIState = mutableStateOf(DetailMenuUIState())
    fun updateTotalMenu(totalMenu: Int){
        detailMenuUIState.value = detailMenuUIState.value.copy(
            totalMenu = totalMenu
        )
    }

    fun getMenuById(menu: Long) {
        viewModelScope.launch {
            _menuState.value = UiState.Loading
            _menuState.value = UiState.Success(repository.getMenuById(menu))
        }
    }

}