package com.example.onlyofficeclient.data.api

import com.example.onlyofficeclient.models.request.auth.AuthRequest
import com.example.onlyofficeclient.models.response.auth.AuthResponse
import com.example.onlyofficeclient.models.response.documents.DocumentsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "Accept: application/json, text/plain, */*",
        "Content-Type: application/json"
    )
    @POST("/api/2.0/authentication")
    suspend fun auth(
        @Body authRequest: AuthRequest
    ): Response<AuthResponse>


    @GET("/api/2.0/files/{id}")
    suspend fun documentsSection(
        @Header("Authorization") asc_auth_key: String,
        @Path("id") id: Int = 626570,
        @Query(QUERY_PARAM_COUNT) count: Int =100,
        @Query(QUERY_PARAM_SORT_BY) sortby: String = "DateAndTime",
        @Query(QUERY_PARAM_SORT_ORDER) sortOrder: String = "descending",
        @Query(QUERY_PARAM_SEARCH_AREA) searchArea: Int = 3
    ): Response<DocumentsResponse>

    companion object {
        private const val QUERY_PARAM_COUNT = "count"
        private const val QUERY_PARAM_SORT_BY = "sortby"
        private const val QUERY_PARAM_SORT_ORDER = "sortOrder"
        private const val QUERY_PARAM_SEARCH_AREA = "searchArea"

    }
}