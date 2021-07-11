package com.example.recipeapp.entities.converter

import androidx.room.TypeConverter
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.CategoryItems
import com.example.recipeapp.framework.fromJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoryListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<CategoryItems>):String?{
        return if (category == null) {
            (null)
        }else {
            val type = object : TypeToken<CategoryItems>(){}.type
            Gson().toJson(category,type) //vracamo string
        }
    }

    @TypeConverter
    fun toCategoryList (categoryString: String):List<CategoryItems>?{
        return if (categoryString == null) {
            (null)
        }else {
            Gson().fromJson(categoryString)
        }
    }
}