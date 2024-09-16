package com.example.sumitapi.network

import com.example.sumitapi.adapters.DashboardResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val keypass: String)

interface ApiService {
    @POST("/sydney/auth")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("/dashboard/{keypass}")
    suspend fun getDashboardEntities(@Path("keypass") keypass: String): Response<DashboardResponse>
}

