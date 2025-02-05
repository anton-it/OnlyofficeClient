package com.example.onlyofficeclient.models.request.auth

data class AuthRequest(
    val userName: String,
    val password: String,
    val passwordHash: String = "",
    val session: Boolean = false,
    val recaptchaResponse: String = "",
    val recaptchaType: Int = 0,
    val culture: String = "en-US"


//    val accessToken: String,
//    val code: String,
//    val codeOAuth: String,
//    val confirmData: ConfirmData,
//    val provider: String,
//    val serializedProfile: String,


)