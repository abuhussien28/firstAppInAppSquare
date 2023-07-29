package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation


class SignUpScreen : Fragment() {
    private lateinit var backArrow: ImageView
    private lateinit var phoneEd: EditText
    private lateinit var emailEd: EditText
    private lateinit var cityEd: EditText
    private lateinit var passwordEd: EditText
    private lateinit var check: CheckBox
    private lateinit var signUpBtn: Button
    private lateinit var loginClick: TextView
    private var phoneNum = ""
    private var email = ""
    private var city = ""
    private var password = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        handleClick()
    }

    private fun initViews() {
        backArrow = requireActivity().findViewById(R.id.image_view_back)
        phoneEd = requireActivity().findViewById(R.id.edit_text_signup_phone)
        emailEd = requireActivity().findViewById(R.id.edit_text_signup_email)
        cityEd = requireActivity().findViewById(R.id.edit_text_signup_city)
        passwordEd = requireActivity().findViewById(R.id.edit_text_password)
        check = requireActivity().findViewById(R.id.check_box_terms)
        signUpBtn = requireActivity().findViewById(R.id.button_sign_up)
        loginClick = requireActivity().findViewById(R.id.text_view_login_account)
    }

    private fun getValue() {
        phoneNum = phoneEd.text.toString()
        email = emailEd.text.toString()
        city = cityEd.text.toString()
        password = passwordEd.text.toString()
    }

    private fun handleClick() {
        backArrow.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
        loginClick.setOnClickListener {
          val action=  SignUpScreenDirections.actionSignUpScreenToLoginScreen()
            Navigation.findNavController(it).navigate(action)
        }
        clickLoginBtn()
    }

    private fun clickLoginBtn() {

        signUpBtn.setOnClickListener {
            getValue()
            if (phoneNum.isEmpty()) requireActivity().toast("please enter phone number")
            else if (phoneNum.length != 11) requireActivity().toast("phone number must be 11 number")
            else if (email.isEmpty()) requireActivity().toast("please enter your email")
            else if (!email.contains("@")) requireActivity().toast("please add @ to your email")
            else if (!email.contains(".")) requireActivity().toast("please add . to your email")
            else if (city.isEmpty()) requireActivity().toast("please enter your city")
            else if (password.isEmpty()) requireActivity().toast("please enter password")
            else if (password.length < 8) requireActivity().toast("password must be more than 8 character")
            else if (!check.isChecked) requireActivity().toast("please check terms")
            else {
              val action=  SignUpScreenDirections.actionSignUpScreenToHomeScreen()
                Navigation.findNavController(it).navigate(action)
            }

        }
    }
}