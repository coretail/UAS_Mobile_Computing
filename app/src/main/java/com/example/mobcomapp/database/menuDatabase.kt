package com.example.mobcomapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mobcomapp.entities.menus
import com.example.mobcomapp.menusDao.menuDao


@Database(entities = [menus::class], version = 1, exportSchema = false)
abstract class MenuDatabase : RoomDatabase() {

    companion object {
        private var instance: MenuDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): MenuDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MenuDatabase::class.java,
                    "menus.db"
                ).fallbackToDestructiveMigration().build()
            }
            return instance!!
        }
    }

    abstract fun menuDao(): menuDao
}
