package com.example.sumitapi.adapters

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class DashboardResponse(
    val entities: List<Entity>,
    val entityTotal: Int
)


@Parcelize
data class Entity(
    val artistName: String?,
    val albumTitle: String?,
    val releaseYear: Int?,
    val genre: String?,
    val trackCount: Int?,
    val description: String?,
    val popularTrack: String?
) : Parcelable

