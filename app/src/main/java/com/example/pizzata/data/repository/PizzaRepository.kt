package com.example.pizzata.data.repository

import com.example.pizzata.model.Menu
import com.example.pizzata.model.dummyMenu
import kotlinx.coroutines.flow.*

class PizzaRepository {

    private val menuList = mutableListOf<Menu>()

    init {
        if (menuList.isEmpty()) {
            dummyMenu.forEach {
                menuList.add(it)
            }
        }
    }

    fun getMenuList(): Flow<List<Menu>> {
        return flowOf(menuList)
    }

    fun getMenuById(id: Long): Menu {
        return menuList.first {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: PizzaRepository? = null

        fun getInstance(): PizzaRepository =
            instance ?: synchronized(this) {
                PizzaRepository().apply {
                    instance = this
                }
            }
    }
}