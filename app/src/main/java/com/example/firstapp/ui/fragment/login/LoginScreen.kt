package com.example.firstapp.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.firstapp.LoginScreenDirections
import com.example.firstapp.databinding.FragmentLoginScreenBinding
import com.example.firstapp.toast
import com.example.firstapp.ui.fragment.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginScreen : Fragment() {
    private var emailEditText = ""
    private var password = ""
    private val viewModel: LoginViewModel by viewModels()
    lateinit var loginBinding:FragmentLoginScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        loginBinding=FragmentLoginScreenBinding.inflate(inflater,container,false)
        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeStates()
        handleClick()
    }
    private  fun observeStates() {
       viewModel.loginLiveData.observe(viewLifecycleOwner) {
           if (it.status==true) {
               val action = LoginScreenDirections.actionLoginScreenToHomeScreen()
               Navigation.findNavController(requireView()).navigate(action)
               requireActivity().toast(it.message.toString())
           }
       }
        viewModel.loginErrorLiveData.observe(viewLifecycleOwner) {
            requireActivity().toast(it.toString())
        }

    }

    private fun getValue() {
        loginBinding.apply {
            emailEditText=editTextLoginPhoneNum.text.toString()
            password=editTextLoginPassword.text.toString()
        }
    }

    private fun clickLoginBtn() {
        loginBinding.apply {
            buttonLogin.setOnClickListener {
                getValue()
                if (emailEditText.isEmpty()) requireActivity().toast("please enter phone number")
                else if (!emailEditText.contains("@")) requireActivity().toast("please add @ to your email")
                else if (!emailEditText.contains(".")) requireActivity().toast("please add . to your email")
                else if (password.isEmpty()) requireActivity().toast("please enter password")
                else if (password.length < 6) requireActivity().toast("password must be more than 8 character")
                else {
                   viewModel.login(emailEditText,password)
                }
            }
        }
    }

    private fun handleClick() {
        loginBinding.apply {
            textViewSignUpAccount.setOnClickListener {
                val action= LoginScreenDirections.actionLoginScreenToSignUpScreen()
                Navigation.findNavController(it).navigate(action)
            }
            clickLoginBtn()
        }

    }
}