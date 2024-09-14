package com.example.sumitapi;

import Entity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sumitapi.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val property1TextView = findViewById<TextView>(R.id.property1)
        val property2TextView = findViewById<TextView>(R.id.property2)
        val descriptionTextView = findViewById<TextView>(R.id.description)

        // Retrieve the Parcelable Entity from the Intent
        val entity: Entity? = intent.getParcelableExtra("entity")

        // Check if entity is not null before using it
        entity?.let {
            property1TextView.text = it.property1
            property2TextView.text = it.property2
            descriptionTextView.text = it.description
        }
    }
}
