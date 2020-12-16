package com.example.myapplication.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapplication.database.BmiDatabase
import com.example.myapplication.databinding.ActivityHistoryBinding
import com.example.myapplication.repository.BmiRepository
import com.example.myapplication.repository.BmiResultAdapter

class HistoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityHistoryBinding
    lateinit var bmiRepository: BmiRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        bmiRepository = BmiRepository(BmiDatabase.getInstance(context = this).databaseDao)
        super.onCreate(savedInstanceState)

        binding = ActivityHistoryBinding.inflate(layoutInflater)

        setContentView(binding.root)
        bmiRepository.readData().observe(this, Observer {
            if (it.isEmpty()) binding.emptyHistory.visibility = View.VISIBLE

            binding.historyRecyclerView.adapter =
                BmiResultAdapter(
                    it
                )
        })

    }
}