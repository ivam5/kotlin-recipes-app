package com.example.recipeapp.entities.converter

import androidx.room.TypeConverter
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.CategoryItems
import com.example.recipeapp.entities.MealsItems
import com.example.recipeapp.framework.fromJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MealListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<MealsItems>):String?{
        return if (category == null) {
            (null)
        }else {
            val type = object : TypeToken<MealsItems>(){}.type
            Gson().toJson(category,type)
        }
    }

    @TypeConverter
    fun toCategoryList (categoryString: String):List<MealsItems>?{
        return if (categoryString == null) {
            (null)
        }else {
            Gson().fromJson(categoryString)
        }
    }
}