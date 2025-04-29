package com.jaixlabs.algorithmtask

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.jaixlabs.algorithmtask.Adapter.NumberAdapter
import com.jaixlabs.algorithmtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NumberAdapter
    private val numbers = (1..100).toList()
    private val rules = listOf("Odd Numbers", "Even Numbers", "Prime Numbers", "Fibonacci Numbers")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NumberAdapter(numbers, rules[0])

        binding.recyclerView.layoutManager = GridLayoutManager(this, 4)
        binding.recyclerView.adapter = adapter

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, rules)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerRules.adapter = spinnerAdapter

        binding.spinnerRules.setSelection(0)

        binding.spinnerRules.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedRule = rules[position]
                adapter.updateRule(selectedRule)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // do nothing
            }


            private fun androidx.appcompat.widget.AppCompatSpinner.setOnItemSelectedListener(
                listener: (parent: android.widget.AdapterView<*>, view: android.view.View?, position: Int, id: Long) -> Unit
            ) {
                this.onItemSelectedListener =
                    object : android.widget.AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: android.widget.AdapterView<*>,
                            view: android.view.View?,
                            position: Int,
                            id: Long
                        ) {
                            listener(parent, view, position, id)
                        }

                        override fun onNothingSelected(parent: android.widget.AdapterView<*>) {}
                    }
            }
        }
    }
}