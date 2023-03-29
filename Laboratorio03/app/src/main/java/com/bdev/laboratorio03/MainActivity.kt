package com.bdev.laboratorio03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var action5:ImageView
    private lateinit var action10:ImageView
    private lateinit var action25:ImageView
    private lateinit var action1:ImageView
    private lateinit var resultMoney:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        clickListener()
    }

    private fun clickListener(){
        action1.setOnClickListener(){
            addValue(1.0.toFloat())
        }
        action5.setOnClickListener(){
            addValue(0.05.toFloat())
        }
        action10.setOnClickListener(){
            addValue(0.10.toFloat())
        }
        action25.setOnClickListener(){
            addValue(0.25.toFloat())
        }
    }

    private fun addValue(value: Float){
        var result = resultMoney.text.toString().toFloat()
        result += value
        resultMoney.text = String.format("%.2f", result)
    }

    private fun bind(){
        action5 = findViewById(R.id.iv_5)
        action10 = findViewById(R.id.iv_10)
        action25 = findViewById(R.id.iv_25)
        action1 = findViewById(R.id.iv_1)
        resultMoney = findViewById(R.id.tvMoneyCuantity)
    }
}