package com.example.mobile_tono.Note

import com.google.gson.annotations.SerializedName

data class Note(
    val id: Int? = null,
    val title: String,
    val content: String,
    val status: String? = "To Do",
    @SerializedName("created_at")
    val createdAt: String? = null
)
