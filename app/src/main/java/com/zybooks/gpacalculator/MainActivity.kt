package com.zybooks.gpacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var numAsEditText: EditText
    private lateinit var numBsEditText: EditText
    private lateinit var numCsEditText: EditText
    private lateinit var numDsEditText: EditText
    private lateinit var numFsEditText: EditText
    private lateinit var GPA: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAsEditText = findViewById(R.id.AInput)
        numBsEditText = findViewById(R.id.BInput)
        numCsEditText = findViewById(R.id.CInput)
        numDsEditText = findViewById(R.id.DInput)
        numFsEditText = findViewById(R.id.FInput)
    }

    fun calculateGPA(view: View) {

    }



}