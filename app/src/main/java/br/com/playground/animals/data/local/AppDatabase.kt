package br.com.playground.animals.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.playground.animals.data.local.dao.AnimalDao
import br.com.playground.animals.data.local.entity.AnimalEntity

@Database(entities = [AnimalEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAnimalDao(): AnimalDao

    companion object {

        fun getDataBase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).build()
        }
    }
}
