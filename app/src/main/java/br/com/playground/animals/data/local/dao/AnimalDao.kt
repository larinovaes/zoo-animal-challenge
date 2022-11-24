package br.com.playground.animals.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.playground.animals.data.local.entity.AnimalEntity

@Dao
interface AnimalDao {

    @Query("SELECT * FROM animal")
    suspend fun getAllAnimals(): List<AnimalEntity>

    @Insert
    suspend fun insertAnimal(animals: List<AnimalEntity>)

    @Query("DELETE from animal")
    suspend fun deleteAll()

    suspend fun update(animals: List<AnimalEntity>) {
        deleteAll()
        insertAnimal(animals)
    }
}
