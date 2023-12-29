package com.example.mobcomapp.menusDao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.mobcomapp.entities.menus

@Dao
interface menuDao {
    @get:Query("SELECT * FROM menus ORDER BY id DESC")
    val allmenus: List<menus>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMenus(menus: menus)
}