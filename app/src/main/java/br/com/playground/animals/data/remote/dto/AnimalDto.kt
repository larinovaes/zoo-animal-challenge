package br.com.playground.animals.data.remote.dto

import br.com.playground.animals.data.local.entity.AnimalEntity
import com.squareup.moshi.Json

data class AnimalDto(
    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "latin_name")
    val latinName: String,

    @Json(name = "animal_type")
    val animalType: String,

    @Json(name = "active_time")
    val activeTime: String,

    @Json(name = "length_min")
    val lengthMin: String,

    @Json(name = "length_max")
    val lengthMax: String,

    @Json(name = "weight_min")
    val weightMin: String,

    @Json(name = "weight_max")
    val weightMax: String,

    @Json(name = "lifespan")
    val lifespan: String,

    @Json(name = "habitat")
    val habitat: String,

    @Json(name = "diet")
    val diet: String,

    @Json(name = "geo_range")
    val geoRange: String,

    @Json(name = "image_link")
    val imageLink: String,
) {

    constructor(animalsEntity: AnimalEntity) : this(
        id = animalsEntity.id,
        name = animalsEntity.name,
        latinName = animalsEntity.latinName,
        animalType = animalsEntity.animalType,
        activeTime = animalsEntity.activeTime,
        lengthMin = animalsEntity.lengthMin,
        lengthMax = animalsEntity.lengthMax,
        weightMin = animalsEntity.weightMin,
        weightMax = animalsEntity.weightMax,
        habitat = animalsEntity.habitat,
        diet = animalsEntity.diet,
        lifespan = animalsEntity.lifespan,
        geoRange = animalsEntity.geoRange,
        imageLink = animalsEntity.imageLink
    )
}
