package com.example.onlyofficeclient.models.response.auth

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable


data class Response(
    val expires: String,
    val sms: Boolean,
    val tfa: Boolean,
    val token: String
): Serializable