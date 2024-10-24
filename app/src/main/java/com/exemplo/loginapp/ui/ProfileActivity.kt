package com.exemplo.loginapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.exemplo.loginapp.R
import com.exemplo.loginapp.data.AppDatabase
import kotlinx.coroutines.launch
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Carregar usuário do banco de dados
        val db = AppDatabase.getDatabase(this)
        lifecycleScope.launch {
            val user = db.userDao().getUserById(1) // Suponha ID 1
            if (user != null) {
                txtName.text = user.name
                txtEmail.text = user.email
                // Carregar imagem do perfil (a lógica da URI pode ser adicionada)
            }
        }

        btnEdit.setOnClickListener {
            val intent = Intent(this, UpdateUserActivity::class.java)
            startActivity(intent)
        }
    }
}

