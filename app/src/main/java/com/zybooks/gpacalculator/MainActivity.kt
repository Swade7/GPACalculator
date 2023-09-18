package com.zybooks.gpacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Grades
    private lateinit var gradeOneGradeEditText: EditText
    private lateinit var gradeTwoGradeEditText: EditText
    private lateinit var gradeThreeGradeEditText: EditText
    private lateinit var gradeFourGradeEditText: EditText
    private lateinit var gradeFiveGradeEditText: EditText

    // Credit hours
    private lateinit var gradeOneHoursEditText: EditText
    private lateinit var gradeTwoHoursEditText: EditText
    private lateinit var gradeThreeHoursEditText: EditText
    private lateinit var gradeFourHoursEditText: EditText
    private lateinit var gradeFiveHoursEditText: EditText
    private lateinit var GPATextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Grades
        gradeOneGradeEditText = findViewById(R.id.grade_one_grade)
        gradeTwoGradeEditText = findViewById(R.id.grade_two_grade)
        gradeThreeGradeEditText = findViewById(R.id.grade_three_grade)
        gradeFourGradeEditText = findViewById(R.id.grade_four_grade)
        gradeFiveGradeEditText = findViewById(R.id.grade_five_grade)

        // Credit hours
        gradeOneHoursEditText = findViewById(R.id.grade_one_hours)
        gradeTwoHoursEditText = findViewById(R.id.grade_two_hours)
        gradeThreeHoursEditText = findViewById(R.id.grade_three_hours)
        gradeFourHoursEditText = findViewById(R.id.grade_four_hours)
        gradeFiveHoursEditText = findViewById(R.id.grade_five_hours)

        // GPA
        GPATextView = findViewById(R.id.GPAResult)

    }

    // Helper function to check if the grade is a valid grade
    private fun checkValidGrade(grade: String): Int {
        val upperGrade = grade.uppercase()

        if (upperGrade == "A" || upperGrade == "B" || upperGrade == "C"
            || upperGrade == "D" || upperGrade == "F") {
            return 1
        }
        else if(grade == "") {
                return 0
        }
        else {
            return -1
        }
    }

    // Helper function to convert a grade to an integer
    private fun gradeToInt(grade: String): Int
    {
        val upperGrade = grade.uppercase()
        val intGrade = when (upperGrade) {
            "A" -> 4
            "B" -> 3
            "C" -> 2
            "D" -> 1
            else -> 0
        }
        return intGrade
    }

    // Helper function to sum the total credit hours
    private fun sumCreditHours(grade: String, hours: Int): Int {
        if (checkValidGrade(grade) == 1) {
                 return hours
            }
        else {
            return 0
        }

    }

    // Helper function to sum the values of the grades
    private fun sumGradeValues(grade: String, hours: Int): Int {

        if (checkValidGrade(grade) == 1) {
            return gradeToInt(grade) * hours
        }
        else {
            return 0
        }
    }

    // Helper function to check for invalid grades
    private fun checkValidInput(grade: String, hours: Int): Boolean {
        // Check if the grade is invalid
        if (checkValidGrade(grade) == -1) {
            Toast.makeText(this, "Invalid grade!", Toast.LENGTH_SHORT).show()
            return false
        }
        // Check if a grade has been provided without credit hours
        else if (checkValidGrade(grade) == 1 && hours == 0) {
            Toast.makeText(this, "A grade was entered without any credit hours!", Toast.LENGTH_SHORT).show()
            return false
        }
        // Check if credit hours have been provided without a grade
        else if (checkValidGrade(grade) == 0 && hours > 0) {
            Toast.makeText(this, "Credit hours were entered without a corresponding grade!", Toast.LENGTH_SHORT).show()
            return false
        }
        // Check for negative credit hours
        else if (hours < 0) {
            Toast.makeText(this, "Cannot enter negative credit hours!", Toast.LENGTH_SHORT).show()
            return false
        }
        else {
            return true
        }
    }


    fun calculateGPA(view: View) {
        // Get the values provided by the user
        // Grades
        val gradeOneGradeStr = gradeOneGradeEditText.text.toString()
        val gradeTwoGradeStr = gradeTwoGradeEditText.text.toString()
        val gradeThreeGradeStr = gradeThreeGradeEditText.text.toString()
        val gradeFourGradeStr = gradeFourGradeEditText.text.toString()
        val gradeFiveGradeStr = gradeFiveGradeEditText.text.toString()

        // Hours
        val gradeOneHoursStr = gradeOneHoursEditText.text.toString()
        val gradeTwoHoursStr = gradeTwoHoursEditText.text.toString()
        val gradeThreeHoursStr = gradeThreeHoursEditText.text.toString()
        val gradeFourHoursStr = gradeFourHoursEditText.text.toString()
        val gradeFiveHoursStr = gradeFiveHoursEditText.text.toString()

        // Convert the hours into integers, if null make
        val gradeOneHours = gradeOneHoursStr.toIntOrNull() ?: 0
        val gradeTwoHours = gradeTwoHoursStr.toIntOrNull() ?: 0
        val gradeThreeHours = gradeThreeHoursStr.toIntOrNull() ?: 0
        val gradeFourHours = gradeFourHoursStr.toIntOrNull() ?: 0
        val gradeFiveHours = gradeFiveHoursStr.toIntOrNull() ?: 0

        // count the number of hours taken and the value of the credit
        var sumHours = 0
        var sumCreditValue = 0

        // Check if each input is valid. Allow empty EditText boxes only if the paired box is also empty
        if ((checkValidInput(gradeOneGradeStr, gradeOneHours))
            && checkValidInput(gradeTwoGradeStr, gradeTwoHours)
            && checkValidInput(gradeThreeGradeStr, gradeThreeHours)
            && checkValidInput(gradeFourGradeStr, gradeFourHours)
            && checkValidInput(gradeFiveGradeStr, gradeFiveHours)) {

            // Grade 1
            sumHours += sumCreditHours(gradeOneGradeStr, gradeOneHours)
            sumCreditValue += sumGradeValues(gradeOneGradeStr, gradeOneHours)
            // Grade 2
            sumHours += sumCreditHours(gradeTwoGradeStr, gradeTwoHours)
            sumCreditValue += sumGradeValues(gradeTwoGradeStr, gradeTwoHours)
            // Grade 3
            sumHours += sumCreditHours(gradeThreeGradeStr, gradeThreeHours)
            sumCreditValue += sumGradeValues(gradeThreeGradeStr, gradeThreeHours)
            // Grade 4
            sumHours += sumCreditHours(gradeFourGradeStr, gradeFourHours)
            sumCreditValue += sumGradeValues(gradeFourGradeStr, gradeFourHours)
            // grade 5
            sumHours += sumCreditHours(gradeFiveGradeStr, gradeFiveHours)
            sumCreditValue += sumGradeValues(gradeFiveGradeStr, gradeFiveHours)

            // Calculate the GPA
            val GPA: String = String.format("%.2f", sumCreditValue.toFloat() / sumHours.toFloat())
            GPATextView.text = GPA
        }



    }



}