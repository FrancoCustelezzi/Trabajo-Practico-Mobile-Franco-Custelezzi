package com.example.tp1francodayana

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.tp1francodayana.data.User
import com.example.tp1francodayana.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val userViewModel by viewModels<UserViewmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSingIn.setOnClickListener {

            val user = binding.etUser.text.toString()
            val mail = binding.etMail.text.toString()

            if (user.isNotEmpty() && mail.isNotEmpty()){
                val user = userViewModel.selectUserByMail(User(0, user, mail))
                if (user!= null){
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                }


            }else{
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnSingUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}