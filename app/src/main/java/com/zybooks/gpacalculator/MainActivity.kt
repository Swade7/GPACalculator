package com.zybooks.gpacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

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
    fun checkValidGrade(grade: String, hours: Int): Boolean {
        val upperGrade = grade.uppercase()

        return (upperGrade == "A" || upperGrade == "B" || upperGrade == "C"
                || upperGrade == "D" || upperGrade == "F")
                && (hours > 0)
    }

    // Helper function to convert a grade to an integer
    fun gradeToInt(grade: String): Int
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
    fun sumCreditHours(grade: String, hours: Int): Int {
        if (checkValidGrade(grade, hours)) {
                 return hours
            }
        else {
            return 0
        }

    }

    // Helper function to sum the values of the grades
    fun sumGradeValues(grade: String, hours: Int): Int {

        if (checkValidGrade(grade, hours)) {
            return gradeToInt(grade)
        }
        else {
            return 0
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
        val GPA: Float = sumCreditValue.toFloat() / sumHours.toFloat()
        GPATextView.text = GPA.toString()
    }



}