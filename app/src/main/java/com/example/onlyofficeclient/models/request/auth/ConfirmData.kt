package com.example.onlyofficeclient.models.request.auth

data class ConfirmData(
    val email: String,
    val first: Boolean,
    val key: String
)