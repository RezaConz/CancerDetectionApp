package com.dicoding.asclepius.view.save

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SaveViewModelFactory(private val application: Application): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SaveViewModel::class.java)) {
            return SaveViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: SaveViewModelFactory? = null

        fun getInstance(application: Application): SaveViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: SaveViewModelFactory(application)
            }.also { instance = it }
    }
}