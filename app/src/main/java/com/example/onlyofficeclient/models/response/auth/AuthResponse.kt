package com.example.onlyofficeclient.models.response.auth

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable


data class AuthResponse(
    val count: Int,
    val links: List<Link>,
    val response: Response,
    val status: Int,
    val statusCode: Int
): Serializable