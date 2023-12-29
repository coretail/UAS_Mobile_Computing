package com.example.mobcomapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "menus")
data class menus(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "cake_name")
    var menuName:String,

    @ColumnInfo(name = "cake_img")
    var cakeImg:Int

) : Serializable