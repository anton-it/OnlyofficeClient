package com.example.onlyofficeclient.models.response.auth

data class AuthResponse(
    val count: Int,
    val links: List<Link>,
    val response: Response,
    val status: Int,
    val statusCode: Int
)