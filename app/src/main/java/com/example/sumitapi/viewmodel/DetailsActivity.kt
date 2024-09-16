package com.example.sumitapi.viewmodel

import android.os.Bundle
import android.widget.Button
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
        val artistName: TextView = findViewById(R.id.artistName)
        val albumTitle: TextView = findViewById(R.id.albumTitle)
        val releaseYear: TextView = findViewById(R.id.releaseYear)
        val genre: TextView = findViewById(R.id.genre)
        val trackCount: TextView = findViewById(R.id.trackCount)
        val popularTrack: TextView = findViewById(R.id.popularTrack)
        val description: TextView = findViewById(R.id.description)
        val backButton: Button = findViewById(R.id.backButton)

        // Set text from the entity
        artistName.text = "Artist Name: ${entity?.artistName}"
        albumTitle.text = "Album Title: ${entity?.albumTitle}"
        releaseYear.text = "Release Year: ${entity?.releaseYear}"
        genre.text = "Genre: ${entity?.genre}"
        trackCount.text = "Track Count: ${entity?.trackCount}"
        popularTrack.text = "Popular Track: ${entity?.popularTrack}"
        description.text = "Description: ${entity?.description}"

        // Set up back button click listener
        backButton.setOnClickListener {
            finish() // Finish the current activity and return to the previous one
        }
    }
}
