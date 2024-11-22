package com.example.tp1francodayana

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.tp1francodayana.data.User
import com.example.tp1francodayana.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val userViewModel by viewModels<UserViewmodel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val viewModel = ViewModelProvider(this).get(UserViewmodel::class.java)

        binding.btnSingIn.setOnClickListener {
            val user = binding.etUser.text.toString()
            val mail = binding.etMail.text.toString()
            val age = binding.etAge.text.toString()

            if (user.isNotEmpty() && mail.isNotEmpty() && age.isNotEmpty()){
                val user = User(0, user, mail)
                userViewModel.insert(user)
                goToMainActivity()
            }else{
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val CREDENTIALS = "Credenciales"
    }



}