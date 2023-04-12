package com.bdev.laboratorio04.iu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bdev.laboratorio04.R
import com.bdev.laboratorio04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // VIEW BINDING

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // SAVE BUTTTON

        binding.SaveButtonMain.setOnClickListener{

            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra(NAME, binding.InputNameMain.text.toString())
            intent.putExtra(EMAIL, binding.InputEmailMain.text.toString())
            intent.putExtra(PHONE, binding.InputPhoneNumberMain.text.toString())

            startActivity(intent)
        }


    }

    companion object {
        const val NAME = "name"
        const val EMAIL = "email"
        const val PHONE = "phone"
    }
}

