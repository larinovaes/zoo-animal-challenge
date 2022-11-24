package br.com.playground.animals.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.playground.animals.data.remote.dto.AnimalDto

@Entity(tableName = "animal")
data class AnimalEntity(
    @PrimaryKey val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "latin_name")
    val latinName: String,

    @ColumnInfo(name = "animal_type")
    val animalType: String,

    @ColumnInfo(name = "active_time")
    val activeTime: String,

    @ColumnInfo(name = "length_min")
    val lengthMin: String,

    @ColumnInfo(name = "length_max")
    val lengthMax: String,

    @ColumnInfo(name = "weight_min")
    val weightMin: String,

    @ColumnInfo(name = "weight_max")
    val weightMax: String,

    @ColumnInfo(name = "lifespan")
    val lifespan: String,

    @ColumnInfo(name = "habitat")
    val habitat: String,

    @ColumnInfo(name = "diet")
    val diet: String,

    @ColumnInfo(name = "geo_range")
    val geoRange: String,

    @ColumnInfo(name = "image_link")
    val imageLink: String,
) {

    constructor(animalDto: AnimalDto) : this(
        id = animalDto.id,
        name = animalDto.name,
        latinName = animalDto.latinName,
        animalType = animalDto.animalType,
        activeTime = animalDto.activeTime,
        lengthMin = animalDto.lengthMin,
        lengthMax = animalDto.lengthMax,
        weightMin = animalDto.weightMin,
        weightMax = animalDto.weightMax,
        habitat = animalDto.habitat,
        diet = animalDto.diet,
        lifespan = animalDto.lifespan,
        geoRange = animalDto.geoRange,
        imageLink = animalDto.imageLink
    )
}
