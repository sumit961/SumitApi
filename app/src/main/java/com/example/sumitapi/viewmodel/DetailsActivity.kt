package com.example.sumitapi.viewmodel

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sumitapi.adapters.Entity
import com.example.test8.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Retrieve the entity from the intent
        val entity: Entity? = intent.getParcelableExtra("ENTITY")

        // Find views
        val property1TextView: TextView = findViewById(R.id.property1TextView)
        val property2TextView: TextView = findViewById(R.id.property2TextView)
        val descriptionTextView: TextView = findViewById(R.id.descriptionTextView)

        // Set text from the entity
        property1TextView.text = entity?.artistName
        property2TextView.text = entity?.albumTitle
        descriptionTextView.text = entity?.description
    }
}
