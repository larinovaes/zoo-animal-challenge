package br.com.playground.animals.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.playground.animals.R
import br.com.playground.animals.databinding.ActivityAnimalDetailsBinding
import br.com.playground.animals.domain.model.AnimalModel
import coil.load

class AnimalDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimalDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupView()
    }

    private fun setupView() {
        val payload = intent.getParcelableExtra(PAYLOAD, AnimalModel::class.java)
            ?: error("Animal Details is required to initialize AnimalDetails Activity")
        binding.toolbar.setNavigationOnClickListener { finish() }
        binding.imageViewAnimal.load(payload.imageUrl)
        binding.textViewDiet.text = getString(R.string.animal_details_diet, payload.diet)
        binding.textViewLifespan.text = getString(R.string.animal_details_lifespan, payload.lifespan)
    }

    companion object {
        private const val PAYLOAD = "animal_details"

        fun getIntent(context: Context, animalModel: AnimalModel): Intent {
            val intent = Intent(context, AnimalDetailsActivity::class.java)
            intent.putExtra(PAYLOAD, animalModel)
            return intent
        }
    }
}
