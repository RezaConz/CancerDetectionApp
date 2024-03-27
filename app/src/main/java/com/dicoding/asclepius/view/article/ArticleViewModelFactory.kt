package com.dicoding.asclepius.view.article


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.asclepius.data.repository.ArticleRepository
import com.dicoding.asclepius.di.Injection


class ArticleViewModelFactory private constructor(private val repository: ArticleRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticleViewModel::class.java)) {
            return ArticleViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: ArticleViewModelFactory? = null
        fun getInstance(): ArticleViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ArticleViewModelFactory(Injection.provideRepository())
            }.also { instance = it }
    }
}