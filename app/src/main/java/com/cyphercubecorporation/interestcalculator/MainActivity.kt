package com.cyphercubecorporation.interestcalculator

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnSimpleInterest.setOnClickListener {
            var intent = Intent(this, SimpleInterestActivity::class.java)
            startActivity(intent)
        }

        btnCompoundInterest.setOnClickListener {
            var intent = Intent(this, CompoundInterestActivity::class.java)
            startActivity(intent)
        }
    }
}