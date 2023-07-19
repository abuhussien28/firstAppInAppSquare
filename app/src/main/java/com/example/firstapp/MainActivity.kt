package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        handleClick()
    }
    private fun initViews() {
        backArrow=findViewById(R.id.image_view_back)
        phoneEd = findViewById(R.id.edit_text_signup_phone)
        emailEd = findViewById(R.id.edit_text_signup_email)
        cityEd = findViewById(R.id.edit_text_signup_city)
        passwordEd = findViewById(R.id.edit_text_password)
        check = findViewById(R.id.check_box_terms)
        signUpBtn = findViewById(R.id.button_sign_up)
        loginClick=findViewById(R.id.text_view_login_account)
    }
    private fun getValue() {
        phoneNum = phoneEd.text.toString()
        email=emailEd.text.toString()
        city=cityEd.text.toString()
        password = passwordEd.text.toString()
    }
    private fun handleClick(){
        backArrow.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        loginClick.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        clickLoginBtn()
    }
    private fun clickLoginBtn() {

        signUpBtn.setOnClickListener {
            getValue()
            if (phoneNum.isEmpty()) toast("please enter phone number")
            else if (phoneNum.length != 11) toast("phone number must be 11 number")
            else if (email.isEmpty()) toast("please enter your email")
            else if (!email.contains("@") ) toast("please add @ to your email")
            else if (!email.contains(".") ) toast("please add . to your email")
            else if (city.isEmpty()) toast("please enter your city")
            else if (password.isEmpty()) toast("please enter password")
            else if (password.length < 8) toast("password must be more than 8 character")
            else if (!check.isChecked) toast("please check terms")
            else {
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }

        }
    }

}