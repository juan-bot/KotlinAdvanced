package com.example.profile.presentation.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profile.domain.usecase.GetPockemonsUseCase
import com.example.profile.presentation.presenter.Chat
import com.example.profile.presentation.presenter.TypeChat
import com.example.profile.presentation.view.adapter.AdpPockemon
import kotlinx.coroutines.launch

class PockemonsViewModel : ViewModel() {
    private val getPockemonsUseCase = GetPockemonsUseCase()
    private lateinit var adapter: AdpPockemon
    var adpPocke: MutableLiveData<AdpPockemon> = MutableLiveData()
    fun adapter() {
        viewModelScope.launch {
            val response = getPockemonsUseCase(1000)
            var pockemonList = mutableListOf<Chat>()
            for (i in 0..response.results.size - 1) {
                pockemonList.add(Chat(TypeChat.MESSAGE_SENT, message = "${response.results[i].name}", date = "${response.results[i].url}", checked = false))
            }
            adapter = AdpPockemon(pockemonList)
            adpPocke.postValue(adapter)
        }
    }
}