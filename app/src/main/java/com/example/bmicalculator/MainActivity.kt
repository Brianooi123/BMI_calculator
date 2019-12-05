package com.example.bmicalculator

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val kg = findViewById<EditText>(R.id.editTextWeight)
        val meter = findViewById<EditText>(R.id.editTextHeight)
        val calc = findViewById<Button>(R.id.buttonCalculate)
        val reset = findViewById<Button>(R.id.buttonReset)
        calc.setOnClickListener(View.OnClickListener {
            val height = Math.pow(meter.text.toString().toDouble(),2.toDouble())
            val result = (kg.text.toString().toDouble()/height)
            if (result<18.5){
                imageViewProfile.setImageDrawable(getDrawable(R.drawable.under))
                textViewBMI.setText("BMI is under :"+result.toInt())
            }
            else if(18.5<result&&result<24.9){
                imageViewProfile.setImageDrawable(getDrawable(R.drawable.normal))
                textViewBMI.setText("BMI is normal :"+result.toInt())
            }
            else{
                imageViewProfile.setImageDrawable(getDrawable(R.drawable.over))
                textViewBMI.setText("BMI is over :"+result.toInt())
            }
        })
        reset.setOnClickListener(View.OnClickListener {
            editTextHeight.text.clear()
            editTextWeight.text.clear()
            textViewBMI.setText("BMI :")
            imageViewProfile.setImageDrawable(getDrawable(R.drawable.empty))
        })
    }
}
