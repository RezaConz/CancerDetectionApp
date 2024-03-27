package com.dicoding.asclepius.view.save

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.asclepius.adapter.HistoryAdapter
import com.dicoding.asclepius.databinding.ActivitySaveBinding

class SaveActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySaveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = SaveViewModelFactory.getInstance(application)
        val viewModel: SaveViewModel = ViewModelProvider(this,factory)[SaveViewModel::class.java]

        val adapter = HistoryAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding.rvHistory.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvHistory.addItemDecoration(itemDecoration)

        adapter.onClick = {
            viewModel.delete(it)
        }

        viewModel.getAllHistory().observe(this){list ->
            if (list != null){
                adapter.submitList(list)
                binding.rvHistory.adapter = adapter
            }

            if (list.isEmpty()){
                Toast.makeText(
                    this,
                    "There are no History",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }
}