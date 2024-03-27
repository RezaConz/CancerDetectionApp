package com.dicoding.asclepius.view.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.asclepius.data.remote.response.ArticlesItem
import com.dicoding.asclepius.data.repository.ArticleRepository
import com.dicoding.asclepius.data.Result

class ArticleViewModel(articleRepository: ArticleRepository): ViewModel(){

    val listUser: LiveData<Result<List<ArticlesItem>>> = articleRepository.getListUser()
}