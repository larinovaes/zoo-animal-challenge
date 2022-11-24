package br.com.playground.animals.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.playground.animals.R
import br.com.playground.animals.databinding.ItemAnimalBinding
import br.com.playground.animals.domain.model.AnimalModel
import coil.load
import coil.transform.CircleCropTransformation

class AnimalsAdapter(
    private val onItemClick: (AnimalModel) -> Unit = {},
) : ListAdapter<AnimalModel, AnimalsAdapter.AnimalViewHolder>(AnimalDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAnimalBinding.inflate(inflater, parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class AnimalViewHolder(
        private val binding: ItemAnimalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(animalModel: AnimalModel) {
            binding.imageViewAnimal.load(animalModel.imageUrl) {
                placeholder(R.drawable.ic_circle_placeholder)
                transformations(CircleCropTransformation())
            }
            binding.textViewName.text = animalModel.name
            binding.textViewDescription.text = animalModel.diet
            binding.textViewLifespan.text = animalModel.lifespan
            binding.root.setOnClickListener { onItemClick(animalModel) }
        }
    }

    class AnimalDiffUtil : DiffUtil.ItemCallback<AnimalModel>() {
        override fun areItemsTheSame(oldItem: AnimalModel, newItem: AnimalModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: AnimalModel, newItem: AnimalModel): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
