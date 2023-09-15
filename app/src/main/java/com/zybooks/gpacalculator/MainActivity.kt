package com.zybooks.gpacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var gradeOneGrade: EditText? = null
    private var gradeTwoGrade: EditText? = null
    private var gradeThreeGrade: EditText? = null
    private var gradeFourGrade: EditText? = null
    private var gradeFiveGrade: EditText? = null
    private lateinit var GPA: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gradeOneEditText = findViewById(R.id.grade_one_grade)
        numBsEditText = findViewById(R.id.grade_two_grade)
        numCsEditText = findViewById(R.id.grade_three_grade)
        numDsEditText = findViewById(R.id.grade_four_grade)
        numFsEditText = findViewById(R.id.grade_five_grade)
    }

    fun calculateGPA(view: View) {

    }



}