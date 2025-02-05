package com.example.onlyofficeclient.data.api

import com.example.onlyofficeclient.models.request.auth.AuthRequest
import javax.inject.Inject

class TestRepo @Inject constructor(private val apiService: ApiService) {

    suspend fun auth() = apiService.auth(
        AuthRequest(
            userName = "1one.test901@gmail.com",
            passwordHash = "",
            password = "Testpass123",
            session = false,
            recaptchaResponse = "",
            recaptchaType = 0,
            culture = "en-US"
        )
    )
}