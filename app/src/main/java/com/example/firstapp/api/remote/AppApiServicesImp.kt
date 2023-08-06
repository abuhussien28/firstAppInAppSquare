package com.example.taskappsaqurejetpack.api.remote

import com.example.taskappsaqurejetpack.api.model.login.LoginResponse
import com.example.taskappsaqurejetpack.api.model.signup.SignUpResponse
import retrofit2.Response
import javax.inject.Inject

class AppApiServicesImp  @Inject constructor(private val apiServices: AppApiServices): AppApiServices {
    override suspend fun login(email: String?, password: String?): Response<LoginResponse> {
        return apiServices.login(email, password)
    }

    override suspend fun signUp(
        name: String?,
        email: String?,
        password: String?,
    ): Response<SignUpResponse> {
        return apiServices.signUp(name, email, password)
    }
}