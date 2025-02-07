package com.example.onlyofficeclient.models.response.auth

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable


data class Link(
    val action: String,
    val href: String
): Serializable