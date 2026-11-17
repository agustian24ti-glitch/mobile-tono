package com.example.mobile_tono.Note

import retrofit2.Response
import retrofit2.http.*

interface SupabaseApi {

    @GET("rest/v1/note")
    suspend fun getNotes(
        @Header("apikey") apiKey: String
    ): Response<List<Note>>

    @Headers("Content-Type: application/json")
    @POST("rest/v1/note")
    suspend fun createNote(
        @Header("apikey") apiKey: String,
        @Body note: Note
    ): Response<Unit>

    @Headers("Content-Type: application/json")
    @PATCH("rest/v1/note")
    suspend fun updateNote(
        @Header("apikey") apiKey: String,
        @Query("id") idFilter: String,
        @Body note: Note
    ): Response<Unit>

    @DELETE("rest/v1/note")
    suspend fun deleteNote(
        @Header("apikey") apiKey: String,
        @Query("id") idFilter: String
    ): Response<Unit>
}