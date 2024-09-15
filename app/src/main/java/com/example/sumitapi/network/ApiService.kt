package com.example.sumitapi.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val keypass: String)

interface ApiService {
    @POST("/sydney/auth")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}
