package com.example.firstapp.ui.fragment.signup

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.firstapp.SignUpScreenDirections
import com.example.firstapp.databinding.FragmentSignUpScreenBinding
import com.example.firstapp.toast
import com.example.firstapp.ui.fragment.signup.viewmodel.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignUpScreen : Fragment() {
    private var phoneNum = ""
    private var email = ""
    private var city = ""
    private var password = ""
    private val viewModel: SignUpViewModel by viewModels()
    lateinit var binding:FragmentSignUpScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleClick()
        observeStates()
    }
    private fun getValue() {
        binding.apply {
            phoneNum = editTextSignupPhone.text.toString()
            email = editTextSignupEmail.text.toString()
            city = editTextSignupCity.text.toString()
            password = editTextPassword.text.toString()
        }

    }
    private  fun observeStates() {
        viewModel.signUpLiveData.observe(viewLifecycleOwner) {
            val action = SignUpScreenDirections.actionSignUpScreenToHomeScreen()
            Navigation.findNavController(requireView()).navigate(action)
            requireActivity().toast(it.message.toString())
        }
        viewModel.signUpErrorLiveData.observe(viewLifecycleOwner) {
            requireActivity().toast(it.toString())
        }
    }
    private fun handleClick() {
        binding.apply {
            imageViewBack.setOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }
            textViewLoginAccount.setOnClickListener {
                val action= SignUpScreenDirections.actionSignUpScreenToLoginScreen()
                Navigation.findNavController(it).navigate(action)
            }
            clickLoginBtn()
        }


    }

    private fun clickLoginBtn() {
        binding.apply {
            buttonSignUp.setOnClickListener {
                getValue()
                if (phoneNum.isEmpty()) requireActivity().toast("please enter phone number")
                else if (email.isEmpty()) requireActivity().toast("please enter your email")
                else if (!email.contains("@")) requireActivity().toast("please add @ to your email")
                else if (!email.contains(".")) requireActivity().toast("please add . to your email")
                else if (city.isEmpty()) requireActivity().toast("please enter your city")
                else if (password.isEmpty()) requireActivity().toast("please enter password")
                else if (password.length < 6) requireActivity().toast("password must be more than 8 character")
                else if (!checkBoxTerms.isChecked) requireActivity().toast("please check terms")
                else {
                   viewModel.signUp(phoneNum,email, password)
                }
            }
        }

    }
}