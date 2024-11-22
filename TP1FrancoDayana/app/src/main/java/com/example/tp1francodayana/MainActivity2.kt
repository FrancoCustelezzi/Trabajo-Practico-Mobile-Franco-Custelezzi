package com.example.tp1francodayana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp1francodayana.data.User
import com.example.tp1francodayana.databinding.ActivityMain2Binding
import com.example.tp1francodayana.databinding.ItemUserRecicleViewBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private val userViewModel by viewModels<UserViewmodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = findViewById<RecyclerView>(R.id.listadoRecyclerView)
        val adapter = ListAdapter(
            onUserClick = { user ->
                Toast.makeText(this, "Usuario seleccionado: ${user.name}", Toast.LENGTH_SHORT).show()
            },
            onDeleteClick = { user ->
                userViewModel.delete(user)
                Toast.makeText(this, "Usuario eliminado: ${user.name}", Toast.LENGTH_SHORT).show()
            }
        )

        recyclerView.adapter = adapter

        userViewModel.readAllData.observe( this) { users: List<User> ->
            adapter.setList(users)
        }
        val layout = LinearLayoutManager(this)
        binding.listadoRecyclerView.layoutManager = layout
        binding.listadoRecyclerView.adapter = adapter


// Linea divisoria
        val divider = DividerItemDecoration(this, layout.orientation)
        binding.listadoRecyclerView.addItemDecoration(divider)

        userViewModel.readAllData.observe(this) { userList ->
            adapter.setList(userList = userList)
        }

    }



}