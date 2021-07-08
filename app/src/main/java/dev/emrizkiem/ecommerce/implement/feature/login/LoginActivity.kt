package dev.emrizkiem.ecommerce.implement.feature.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.feature.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvNewAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        tvNewAccount = findViewById(R.id.tv_new_account)

        validation()

        tvNewAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validation() {
        btnLogin.enable(false)
        etEmail.addTextChangedListener {
            btnLogin.enable(
                (etPassword.toString().isNotEmpty()) and
                        (it.toString().isNotEmpty())
            )
        }
    }

    private fun View.enable(isEnable: Boolean) {
        isEnabled = isEnable
        alpha = if (isEnable) 1f else 0.8f
    }
}