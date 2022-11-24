package br.com.playground.animals.presentation.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.playground.animals.component.DialogLoading
import br.com.playground.animals.databinding.ActivityAnimalsBinding
import br.com.playground.animals.domain.model.AnimalModel
import br.com.playground.animals.presentation.details.AnimalDetailsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimalsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimalsBinding
    private lateinit var adapter: AnimalsAdapter
    private val viewModel: AnimalsViewModel by viewModel()
    private val dialogLoading by lazy { DialogLoading(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalsBinding.inflate(layoutInflater)
        viewModel.fetchAnimals()
        initRecyclerView()
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setObservable()
        setListener()
    }

    private fun setListener() = with(binding) {
        toolbar.setNavigationOnClickListener { finish() }
        error.buttonRetry.setOnClickListener { viewModel.fetchAnimals() }
        swipeRefresh.setOnRefreshListener { viewModel.onRefreshAnimals() }
    }

    private fun setObservable() {
        viewModel.uiState.observe(this) { handleUiState(it) }
        viewModel.onRefresh.observe(this) { binding.swipeRefresh.isRefreshing = it }
    }

    private fun handleUiState(state: AnimalsViewModel.UIState) {
        dialogLoading.setLoading(state is AnimalsViewModel.UIState.Loading)
        binding.error.root.isVisible = state is AnimalsViewModel.UIState.Error
        binding.recyclerAnimals.isVisible = state is AnimalsViewModel.UIState.Success
        if (state is AnimalsViewModel.UIState.Success) {
            adapter.submitList(state.animals)
        }
    }

    private fun initRecyclerView() {
        val divider = DividerItemDecoration(this, LinearLayout.VERTICAL)
        adapter = AnimalsAdapter(::startDetailsAnimalActivity)
        binding.recyclerAnimals.addItemDecoration(divider)
        binding.recyclerAnimals.adapter = adapter
    }

    private fun startDetailsAnimalActivity(animal: AnimalModel) {
        val intent = AnimalDetailsActivity.getIntent(this, animal)
        startActivity(intent)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, AnimalsActivity::class.java)
    }
}
