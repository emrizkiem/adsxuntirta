package dev.emrizkiem.ecommerce.implement.feature.register

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.data.User
import dev.emrizkiem.ecommerce.implement.feature.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etFullName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: MaterialButton

    private lateinit var auth: FirebaseAuth
    private lateinit var dbReference: DatabaseReference
    private lateinit var dbInstance: FirebaseDatabase

    private var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etFullName = findViewById(R.id.et_fullname)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnRegister = findViewById(R.id.btn_register)

        auth = FirebaseAuth.getInstance()
        dbInstance = FirebaseDatabase.getInstance()

        isRegister()
    }

    private fun isRegister() {
        btnRegister.setOnClickListener {
            var fullName: String = etFullName.text.toString()
            var email: String = etEmail.text.toString()
            var password: String = etPassword.text.toString()

            if (TextUtils.isEmpty(fullName) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show()

                        dbReference = dbInstance.getReference("users")
                        val users = FirebaseAuth.getInstance().currentUser

                        userId = users?.uid
                        email = users?.email.toString()

                        val myUser = User(
                            name = fullName,
                            email = email,
                            password = password
                        )

                        userId?.let { it -> dbReference.child(it).setValue(myUser) }

                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}