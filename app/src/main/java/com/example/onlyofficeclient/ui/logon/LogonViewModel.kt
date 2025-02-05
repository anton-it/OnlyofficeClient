package com.example.onlyofficeclient.ui.logon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlyofficeclient.models.request.auth.AuthRequest
import com.example.onlyofficeclient.data.api.AppRepository
import com.example.onlyofficeclient.models.response.auth.AuthResponse
import com.example.onlyofficeclient.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class LogonViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {

    private val _authRequestLiveData = MutableLiveData<AuthRequest>()
    val authRequestLiveData: LiveData<AuthRequest>
        get() = _authRequestLiveData

    private val _errorInputEmail = MutableLiveData<Boolean>()
    val errorInputEmail: LiveData<Boolean>
        get() = _errorInputEmail

    private val _errorInputPassword = MutableLiveData<Boolean>()
    val errorInputPassword: LiveData<Boolean>
        get() = _errorInputPassword

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    val authResponseLiveData: MutableLiveData<Resource<AuthResponse>> = MutableLiveData()

    fun auth(inputEmail: String?, inputPassword: String?) {
        viewModelScope.launch {
            val email = parseEmail(inputEmail)
            val password = parsePassword(inputPassword)
            if (validateInput(email, password)) {
                val response = repository.auth(
                    AuthRequest(
                        userName = email,
                        password = password
                    )
                )
                if (response.isSuccessful) {
                    response.body().let { res ->
                        authResponseLiveData.postValue(Resource.Success(res))
                        _shouldCloseScreen.value = Unit
                    }
                } else {
                    val errorMessage = response.errorBody()?.string()?.let {
                        JSONObject(it).getString("error").let {
                            JSONObject(it).getString("message")
                        }
                    }
                    authResponseLiveData.postValue(Resource.Error(message = errorMessage))
                }
            }
        }
    }

    private fun parseEmail(inputEmail: String?): String {
        return inputEmail?.trim() ?: ""
    }

    private fun parsePassword(inputPassword: String?): String {
        return inputPassword?.trim() ?: ""
    }

    private fun validateInput(email: String, password: String): Boolean {
        var result = true
        if (email.isBlank()) {
            _errorInputEmail.value = true
            result = false
        }
        if (password.isBlank()) {
            _errorInputPassword.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputEmail() {
        _errorInputEmail.value = false
    }

    fun resetErrorInputPassword() {
        _errorInputPassword.value = false
    }
}

