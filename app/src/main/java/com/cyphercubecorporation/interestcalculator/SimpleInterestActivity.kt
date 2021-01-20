package com.cyphercubecorporation.interestcalculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_simpleinterest.*

class SimpleInterestActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simpleinterest)

        btnReset.setOnClickListener {
            principal.setText("0")
            rateOfInterest.setText("0")
            years.setText("0")
            months.setText("0")
            totalAmount.setText("0.0000")
            totalInterest.setText("0.0000")
        }

        btnCalculateSimple.setOnClickListener {
            if (sanitizedInput()) {
                totalAmount.text = String.format("%.4f", calculateTotalAmount())
                totalInterest.text = String.format("%.4f",totalAmount.text.toString().toDouble() - principal.text.toString().toDouble())
            } else if (principal.text.isEmpty()) {
                Toast.makeText(this, "Enter the Principal Amount", Toast.LENGTH_LONG).show()
            } else if (rateOfInterest.text.isEmpty()) {
                Toast.makeText(this, "Enter the Interest Rate", Toast.LENGTH_LONG).show()
            } else if (years.text.isEmpty()) {
                Toast.makeText(this, "Enter Number of Years", Toast.LENGTH_LONG).show()
            } else if (months.text.isEmpty()) {
                Toast.makeText(this, "Enter Number of Months", Toast.LENGTH_LONG).show()
            }


        }
    }
    private fun sanitizedInput(): Boolean {
        return (principal.text.isNotEmpty() && rateOfInterest.text.isNotEmpty() && years.text.isNotEmpty() && months.text.isNotEmpty())
    }

    private fun calculateTotalAmount(): Double {
        val p = principal.text.toString().toDouble()
        val r = rateOfInterest.text.toString().toDouble()
        val mon = (years.text.toString().toDouble() * 12) + months.text.toString().toDouble()
        return ((p/100)*r*(mon/12)+p)
    }
}