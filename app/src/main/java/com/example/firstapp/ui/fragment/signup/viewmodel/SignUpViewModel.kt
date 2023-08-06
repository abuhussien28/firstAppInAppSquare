package com.example.firstapp.ui.fragment.signup.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskappsaqurejetpack.api.model.signup.SignUpResponse
import com.example.taskappsaqurejetpack.api.remote.AppApiServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val repository: AppApiServices) : ViewModel() {
    private val _signUpLiveData = MutableLiveData<SignUpResponse>()
    val signUpLiveData: LiveData<SignUpResponse> = _signUpLiveData

    private val _signUpErrorLiveData = MutableLiveData<String>()
    val signUpErrorLiveData: LiveData<String> = _signUpErrorLiveData

    fun signUp(name:String,email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val res = repository.signUp(name,email, password)
                if (res.isSuccessful){
                    _signUpLiveData.postValue(res.body())
                }
                else res.errorBody()
            } catch (e: IOException) {
                e.printStackTrace()
                _signUpErrorLiveData.postValue(e.message.toString())
            } catch (e: HttpException) {
                e.printStackTrace()
                _signUpErrorLiveData.postValue( e.response()?.errorBody().toString())
                Log.d("tag", "signUp:${e.response()?.errorBody().toString()} ")
            } catch (e: Exception) {
                e.printStackTrace()
                _signUpErrorLiveData.postValue(e.message.toString())
            }
        }
    }
}