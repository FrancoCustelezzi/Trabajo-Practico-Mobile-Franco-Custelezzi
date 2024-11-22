package com.example.tp1francodayana

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.tp1francodayana.data.User
import com.example.tp1francodayana.databinding.ItemUserRecicleViewBinding

class ListAdapter(val onUserClick:(user: User) -> Unit,  val onDeleteClick: (user: User) -> Unit): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var userList = emptyList<User>()

    inner class ListViewHolder(private val binding: ItemUserRecicleViewBinding): RecyclerView.ViewHolder(binding.root) {

        val btnDelete = itemView.findViewById<ImageButton>(R.id.btnDelete)

        fun bind(user: User) {
            with(binding) {
                tvName.text = user.name
                tvLastName.text = user.mail
                tvId.text = user.id.toString()
            }

            binding.root.setOnClickListener {
                onUserClick(user)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ListViewHolder {
        val binding = ItemUserRecicleViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ListAdapter.ListViewHolder, position: Int) {
        val user = userList.get(position)
        holder.bind(user = user)

        holder.btnDelete.setOnClickListener {
            onDeleteClick(user)
        }
    }

    override fun getItemCount(): Int = userList.size


    @SuppressLint("NotifyDataSetChanged")
    fun setList(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }
}