package com.example.firstapp.ui.fragment.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskappsaqurejetpack.api.model.login.LoginResponse
import com.example.taskappsaqurejetpack.api.remote.AppApiServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(private val repository: AppApiServices) :ViewModel() {
    private val _loginLiveData = MutableLiveData<LoginResponse>()
    val loginLiveData: LiveData<LoginResponse> = _loginLiveData

    private val _loginErrorLiveData = MutableLiveData<String>()
    val loginErrorLiveData: LiveData<String> = _loginErrorLiveData

    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val res = repository.login(email, password)
                if (res.isSuccessful){
                    _loginLiveData.postValue(res.body())
                }
                else res.errorBody()
            } catch (e: IOException) {
                e.printStackTrace()
                _loginErrorLiveData.postValue(e.message.toString())
            } catch (e: HttpException) {
                e.printStackTrace()
                _loginErrorLiveData.postValue( e.response()?.errorBody().toString())
            } catch (e: Exception) {
                e.printStackTrace()
                _loginErrorLiveData.postValue(e.message.toString())
            }
        }
    }
}