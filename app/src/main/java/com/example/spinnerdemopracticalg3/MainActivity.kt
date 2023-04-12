package com.example.spinnerdemopracticalg3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner : Spinner = findViewById(R.id.CourseSelection)
        spinner.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            this,
            R.array.course_selection,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        val selectionTv : TextView = findViewById(R.id.selectionResults)
        selectionTv.text = parent.getItemAtPosition(pos).toString()

    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        val selectionTv : TextView = findViewById(R.id.selectionResults)
        selectionTv.text= "You have not make a course selection"
    }

}