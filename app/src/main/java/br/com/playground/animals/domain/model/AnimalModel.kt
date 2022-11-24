package br.com.playground.animals.domain.model

import android.os.Parcelable
import br.com.playground.animals.data.remote.dto.AnimalDto
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnimalModel(
    var id: String = "",
    var imageUrl: String = "",
    var name: String = "",
    var diet: String = "",
    var lifespan: String = "",
) : Parcelable {

    constructor(animalDto: AnimalDto) : this(
        id = animalDto.id.toString(),
        imageUrl = animalDto.imageLink,
        name = animalDto.name,
        diet = animalDto.diet,
        lifespan = animalDto.lifespan,
    )
}
