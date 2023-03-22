package com.bdev.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {


    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var actionCalculate: Button
    private lateinit var bmiTextView: TextView
    private lateinit var resultTextView: TextView
    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        setListener()
    }

    private fun bind() {
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        actionCalculate = findViewById(R.id.action_calculate)
        bmiTextView = findViewById(R.id.bmi_text_view)
        resultTextView = findViewById(R.id.result_text_view)
        infoTextView = findViewById(R.id.info_text_view)
    }

    private fun setListener( ) {
        actionCalculate.setOnClickListener {

            val weight = weightEditText.text.toString()
            val height = heightEditText.text.toString()

            if (!validateInputs(weight, height)){
                clearTextView()

                // En vez de usar un else, se usa el return@setOnClickListener
                return@setOnClickListener
            }

            val bmi = calculateBMI(weight.toFloat(), height.toFloat())

            // Formatear los resultados  obtenidos con dos digitos
            val bmiTwoDigits = String.format("%.2f", bmi)


            // Limpiar el foco de los EditText
            clearFocus()

            // Limpiar los inputs
            clearTextView()
            // Mandar los resultados formateados a dos digitos
            displayResult(bmiTwoDigits.toFloat())

        }
    }

    // Funcion para calcular el BMI

    private fun calculateBMI(weight: Float, height: Float): Float{
        return weight / ((height/100) * (height/100))
    }

    // Funcion para validar los imputs

    private fun validateInputs(weight: String?, height: String?): Boolean{
        when{
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Please enter your weight", Toast.LENGTH_SHORT).show()

                return false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Please enter your height", Toast.LENGTH_SHORT).show()

                return false
            }
            else -> {
                clearTextView()
            }
        }

        return true
    }

    // Funcion para mostrar los resultados

    private fun displayResult(bmi:Float){
        bmiTextView.text = bmi.toString()
        infoTextView.text = "(Normal range is 18.80 - 24.9)"

        var informationResult = ""
        var color = 0

        when {
            bmi < 18.5 -> {
                informationResult = "Underweight"
                color = R.color.normal_weight
            }
            bmi in 18.5..24.9 -> {
                informationResult = "Normal"
                color = R.color.under_weight
            }
            bmi in 25.0..29.9 -> {
                informationResult = "Overweight"
                color = R.color.over_weight
            }
            bmi > 30.00 -> {
                informationResult = "Obese"
                color = R.color.obese
            }
        }

        resultTextView.text = informationResult
        resultTextView.setTextColor(ContextCompat.getColor(this, color))


    }

    //Funcion para limpiar el foco de los EditText

    private fun clearFocus(){
        weightEditText.clearFocus()
        heightEditText.clearFocus()
    }

    // Funcion para limpiar los TextView

    private fun clearTextView(){
        bmiTextView.text = ""
        resultTextView.text = ""
        infoTextView.text = ""
    }
}