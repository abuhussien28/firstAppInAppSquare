package com.example.taskappsaqurejetpack.api.remote

import com.example.taskappsaqurejetpack.api.model.login.LoginResponse
import com.example.taskappsaqurejetpack.api.model.signup.SignUpResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface AppApiServices {
    @POST("login")
    @FormUrlEncoded
    suspend fun login(
        @Field("email") email: String?,
        @Field("password") password: String?,
    ): Response<LoginResponse>

    @POST("sign_up")
    @FormUrlEncoded
    suspend fun signUp(
        @Field("name") name: String?,
        @Field("email") email: String?,
        @Field("password") password: String?,
    ): Response<SignUpResponse>
}