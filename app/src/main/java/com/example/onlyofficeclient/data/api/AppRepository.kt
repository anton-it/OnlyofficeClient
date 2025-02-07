package com.example.onlyofficeclient.data.api

import com.example.onlyofficeclient.models.request.auth.AuthRequest
import javax.inject.Inject

class AppRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun auth(authRequest: AuthRequest) = apiService.auth(
            authRequest = authRequest
    )

    suspend fun getDocumentsSection(token: String) = apiService.documentsSection(asc_auth_key = token)
}