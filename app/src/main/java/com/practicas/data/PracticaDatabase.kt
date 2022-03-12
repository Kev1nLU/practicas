package com.practicas.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.practicas.model.Practica

@Database(entities = [Practica::class], version=2, exportSchema = false)
abstract class PracticaDatabase: RoomDatabase() {
    abstract fun practicaDao() : PracticaDao

    companion object{
        @Volatile
        private var INSTANCE: PracticaDatabase? = null

        fun getDatabase(context: android.content.Context) : PracticaDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PracticaDatabase::class.java,
                    "practica_database2"
                ).build()

                INSTANCE = instance
                return instance

            }
        }
    }

}