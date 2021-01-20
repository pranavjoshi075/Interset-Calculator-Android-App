package com.cyphercubecorporation.interestcalculator

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_compoundinterest.*

class CompoundInterestActivity : AppCompatActivity() {
    private lateinit var radioButton: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compoundinterest)

        btnReset.setOnClickListener {
            principal.setText("0")
            rateOfInterest.setText("0")
            years.setText("0")
            months.setText("0")
            totalAmount.setText("0.0000")
            totalInterest.setText("0.0000")
        }
        btnCalculate.setOnClickListener {
            if (sanitizedInput()) {
                val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
                radioButton = findViewById(intSelectButton)
                if (radioButton.text == "Yearly") {
                    totalAmount.text = String.format("%.4f", calculateTotalAmount(1, 12))
                    totalInterest.text = String.format("%.4f",totalAmount.text.toString().toDouble() - principal.text.toString().toDouble())
                }
                if (radioButton.text == "Half Yearly") {
                    totalAmount.text = String.format("%.4f", calculateTotalAmount(2, 6))
                    totalInterest.text = String.format("%.4f",totalAmount.text.toString().toDouble() - principal.text.toString().toDouble())
                }
                if (radioButton.text == "Quarterly") {
                    totalAmount.text = String.format("%.4f", calculateTotalAmount(4, 3))
                    totalInterest.text = String.format("%.4f",totalAmount.text.toString().toDouble() - principal.text.toString().toDouble())
                }
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

    private fun calculateTotalAmount(j: Int, k: Int): Double {
        val p = principal.text.toString().toDouble()
        val r = rateOfInterest.text.toString().toDouble()
        val mon = (years.text.toString().toDouble() * 12) + months.text.toString().toDouble()
        return (p * Math.pow((1 + r / (j * 100.00)), (mon / k)))
    }
}