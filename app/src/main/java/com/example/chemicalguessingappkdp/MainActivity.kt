package com.example.chemicalguessingappkdp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private lateinit var guessEditText: EditText
    private lateinit var addChemicalEditText: EditText
    private lateinit var guessButton: Button
    private lateinit var addChemicalButton: Button
    private lateinit var labelView: TextView
    val chemicalList: MutableList<String> = mutableListOf()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        guessEditText = findViewById(R.id.guessEditText)
        addChemicalEditText = findViewById(R.id.chemicalEditText)
        guessButton = findViewById(R.id.guessButton)
        addChemicalButton = findViewById(R.id.addChemicalButton)
        labelView = findViewById(R.id.labelView)
        // init
        chemicalList.add("Hydrochloric acid")
        chemicalList.add("Sodium chloride")

        // Set onClickListener for the login button

        guessButton.setOnClickListener {
            val guessText = guessEditText.text.toString()
            val selectedValue = chemicalList.random()
            if (guessText == selectedValue) {
                labelView.text = "Congratulation! You guessed it right. It was $selectedValue"
            } else {
                labelView.text =  "Sorry, wrong guess. The correct answer $selectedValue"
            }
           // guessEditText.setText("")
        }

        addChemicalButton.setOnClickListener {
            val newChemical = addChemicalEditText.text.toString()
            val indexChemical = chemicalList.indexOf(newChemical)
            print("chemical")
            print(indexChemical )
            if (indexChemical==-1) {
                chemicalList.add(newChemical)
                labelView.text = "Chemical '$newChemical' added successfully"
            } else {
                labelView.text =  "Chemical '$newChemical' is already available"
            }
           // addChemicalEditText.setText("")
        }
    }
}
