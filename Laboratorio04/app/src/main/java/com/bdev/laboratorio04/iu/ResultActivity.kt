package com.bdev.laboratorio04.iu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bdev.laboratorio04.R
import com.bdev.laboratorio04.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(MainActivity.NAME).toString()
        val email = intent.getStringExtra(MainActivity.EMAIL).toString()
        val phone = intent.getStringExtra(MainActivity.PHONE).toString()

        binding.NameTextView.apply {
            text = getString(R.string.name_share_value, name)
        }

        binding.EmailTextView.apply {
            text = getString(R.string.mail_share_value, email)
        }

        binding.PhoneNumberTextView.apply {
            text = getString(R.string.phone_numer_share_value, phone)
        }

        // SHARE BUTTON

        binding.ActionShareValue.setOnClickListener {
            val share = Intent.createChooser(Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Informacion de contacto:\nNombre: $name \nCorreo electronico: $email\nNumero de telefono: $phone")
            }, "Compartir con:")
            startActivity(share)
        }
    }
}