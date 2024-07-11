package com.example.pizzata.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pizzata.ui.screen.home.HomeViewModel
import com.example.pizzata.ui.screen.menu.MenuViewModel
import com.example.pizzata.ui.screen.menu.detailmenu.DetailMenuViewModel
import com.example.pizzata.data.repository.PizzaRepository

class ViewModelFactory( private var repository: PizzaRepository) :

        ViewModelProvider.NewInstanceFactory(){

        @Suppress("UNCHECKED_CAST")

        override fun <T : ViewModel> create(modelClass: Class<T>) : T {
            if (modelClass.isAssignableFrom(DetailMenuViewModel::class.java)) {
                return DetailMenuViewModel(repository) as T
            } else if(modelClass.isAssignableFrom(MenuViewModel::class.java)) {
                return MenuViewModel(repository) as T
            } else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(repository) as T
            }

            throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
}