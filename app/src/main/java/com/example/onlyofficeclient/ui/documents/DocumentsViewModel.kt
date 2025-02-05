package com.example.onlyofficeclient.ui.documents

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlyofficeclient.data.api.AppRepository
import com.example.onlyofficeclient.models.request.auth.AuthRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DocumentsViewModel @Inject constructor(private val repository: AppRepository): ViewModel() {

    private val _authRequestLiveData = MutableLiveData<AuthRequest>()
    val authRequestLiveData: LiveData<AuthRequest>
        get() = _authRequestLiveData

    fun getDocumentsSection() {
        viewModelScope.launch {
            repository.getDocumentsSection()
//            Log.d("MyLog1111", "DocumentsViewModel init")

//                if (response.isSuccessful) {
//                    response.body().let { res ->
//                        authResponseLiveData.postValue(Resource.Success(res))
//                        _shouldCloseScreen.value = Unit
//                    }
//                } else {
//                    val errorMessage = response.errorBody()?.string()?.let {
//                        JSONObject(it).getString("error").let {
//                            JSONObject(it).getString("message")
//                        }
//                    }
//                    authResponseLiveData.postValue(Resource.Error(message = errorMessage))
//                }
//            }
        }
    }
}