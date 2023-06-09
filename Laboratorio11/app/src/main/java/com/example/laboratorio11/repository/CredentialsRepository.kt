package com.example.laboratorio11.repository

import com.example.laboratorio11.network.ApiResponse
import com.example.laboratorio11.network.dto.login.LoginRequest
import com.example.laboratorio11.network.dto.login.LoginResponse
import com.example.laboratorio11.network.dto.register.RegisterRequest
import com.example.laboratorio11.network.dto.register.RegisterResponse
import com.example.laboratorio11.network.service.AuthService
import retrofit2.HttpException
import java.io.IOException

class CredentialsRepository(private val api: AuthService) {

    suspend fun login(email: String, password: String): ApiResponse<String> {
        try {
            val response: LoginResponse = api.login(LoginRequest(email, password))
            return ApiResponse.Success(response.token)

        } catch (e: HttpException) {
            if (e.code() == 400){
                return ApiResponse.ErrorWithMessage("Invalid credentials email or password")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }

    suspend fun register(name:String ,email: String, password: String): ApiResponse<String> {
        try {
            val response: RegisterResponse =
                api.register(RegisterRequest(name, email, password))
            return ApiResponse.Success(response.msg)

        } catch (e: HttpException) {
            if (e.code() == 400){
                return ApiResponse.ErrorWithMessage("email already exists")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }
}