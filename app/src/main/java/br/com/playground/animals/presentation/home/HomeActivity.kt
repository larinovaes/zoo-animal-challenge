package br.com.playground.animals.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.playground.animals.databinding.ActivityHomeBinding
import br.com.playground.animals.presentation.list.AnimalsActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.buttonStartAnimals.setOnClickListener {
            startActivity(AnimalsActivity.getIntent(this))
        }
    }
}
