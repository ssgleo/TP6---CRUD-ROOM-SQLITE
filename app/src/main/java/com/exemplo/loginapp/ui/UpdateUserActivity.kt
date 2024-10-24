package com.exemplo.loginapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.exemplo.loginapp.R
import com.exemplo.loginapp.data.AppDatabase
import com.exemplo.loginapp.data.User
import kotlinx.coroutines.launch
import kotlinx.android.synthetic.main.activity_update_user.*

class UpdateUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user)

        val db = AppDatabase.getDatabase(this)
        val userDao = db.userDao()

        btnSave.setOnClickListener {
            lifecycleScope.launch {
                val user = User(
                    name = edtName.text.toString(),
                    email = edtEmail.text.toString(),
                    profilePicture = "uri_of_profile_image" // Coloque aqui a lógica de URI para a imagem
                )
                userDao.updateUser(user)
            }
        }

        btnDelete.setOnClickListener {
            lifecycleScope.launch {
                val user = userDao.getUserById(1) // Suponha ID 1
                if (user != null) {
                    userDao.deleteUser(user)
                }
            }
        }
    }
}

