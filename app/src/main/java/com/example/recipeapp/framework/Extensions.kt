package com.example.recipeapp.framework

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun<reified T:Activity> Context.startActivity() = startActivity(Intent(this,T::class.java).apply {
    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
})

inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>(){}.type)