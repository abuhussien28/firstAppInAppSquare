package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation


class LoginScreen : Fragment() {
    private lateinit var phoneEd: EditText
    private lateinit var passwordEd: EditText
    private lateinit var loginBtn: Button
    private lateinit var signUpClick: TextView
    private var phoneNum = ""
    private var password = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        handleClick()
    }
    private fun initViews() {
        phoneEd = requireActivity().findViewById(R.id.edit_text_login_phone_num)
        passwordEd = requireActivity().findViewById(R.id.edit_text_login_password)
        loginBtn = requireActivity().findViewById(R.id.button_login)
        signUpClick = requireActivity().findViewById(R.id.text_view_sign_up_account)
    }

    private fun getValue() {
        phoneNum = phoneEd.text.toString()
        password = passwordEd.text.toString()
    }

    private fun clickLoginBtn() {
        loginBtn.setOnClickListener {
            getValue()
            if (phoneNum.isEmpty()) requireActivity().toast("please enter phone number")
            else if (phoneNum.length != 11) requireActivity().toast("phone number must be 11 number")
            else if (password.isEmpty()) requireActivity().toast("please enter password")
            else if (password.length < 8) requireActivity().toast("password must be more than 8 character")
            else {
               val action = LoginScreenDirections.actionLoginScreenToHomeScreen()
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    private fun handleClick() {
        signUpClick.setOnClickListener {
            val action=LoginScreenDirections.actionLoginScreenToSignUpScreen()
            Navigation.findNavController(it).navigate(action)
        }
        clickLoginBtn()
    }
}