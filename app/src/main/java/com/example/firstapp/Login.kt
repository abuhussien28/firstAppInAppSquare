package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {
    private lateinit var phoneEd: EditText
    private lateinit var passwordEd: EditText
    private lateinit var loginBtn: Button
    private lateinit var signUpClick: TextView
    private var phoneNum = ""
    private var password = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
        handleClick()
    }

    private fun initViews() {
        phoneEd = findViewById(R.id.edit_text_login_phone_num)
        passwordEd = findViewById(R.id.edit_text_login_password)
        loginBtn = findViewById(R.id.button_login)
        signUpClick = findViewById(R.id.text_view_sign_up_account)
    }

    private fun getValue() {
        phoneNum = phoneEd.text.toString()
        password = passwordEd.text.toString()
    }

    private fun clickLoginBtn() {

        loginBtn.setOnClickListener {
            getValue()
            if (phoneNum.isEmpty()) toast("please enter phone number")
            else if (phoneNum.length != 11) toast("phone number must be 11 number")
            else if (password.isEmpty()) toast("please enter password")
            else if (password.length < 8) toast("password must be more than 8 character")
            else {
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }

        }
    }

    private fun handleClick() {
        signUpClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        clickLoginBtn()
    }
}