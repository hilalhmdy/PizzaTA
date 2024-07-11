package com.example.pizzata.ui.screen.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzata.model.Menu
import com.example.pizzata.ui.common.UiState
import com.example.pizzata.data.repository.PizzaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MenuViewModel (
    private val repository: PizzaRepository
    ) : ViewModel() {

    private val _menuState: MutableStateFlow<UiState<List<Menu>>> = MutableStateFlow(UiState.Loading)
    val menuState: StateFlow<UiState<List<Menu>>>
        get() = _menuState

    fun getAllMenu() {
        viewModelScope.launch {
            repository.getMenuList()
                .catch {
                    _menuState.value = UiState.Error(it.message.toString())
                }
                .collect { menu ->
                    _menuState.value = UiState.Success(menu)
                }
        }
    }
}