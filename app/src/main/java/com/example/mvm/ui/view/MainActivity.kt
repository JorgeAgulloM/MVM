package com.example.mvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.mvm.ViewModel.QuoteViewModel
import com.example.mvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //Creates all viewModel logic in the activity
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        //when the lifeData has a change this code will be executed.
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })
        quoteViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        //when the display is clicked on, the data to be displayed will be changed randomly.
        binding.viewContainer.setOnClickListener {quoteViewModel.randomQuote()}

    }
}