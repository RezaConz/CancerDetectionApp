package com.dicoding.asclepius.di

import com.dicoding.asclepius.data.remote.retrofit.ApiConfig
import com.dicoding.asclepius.data.repository.ArticleRepository

object Injection {
    fun provideRepository(): ArticleRepository {
        val apiService = ApiConfig.getApiService()

        return ArticleRepository(apiService)
    }
}