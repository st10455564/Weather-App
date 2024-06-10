package com.example.weatherapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.weatherapp.databinding.ActivityDetailBinding

class Detail : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnAverage.setOnClickListener {

            val mondayTextMin = binding.etMin1.text.toString().toInt()
            val mondayTextMax = binding.etMax1.text.toString().toInt()
            val mondayCondition = binding.etCondition1.text.toString()
            val tuesdayTextMin = binding.etMin2.text.toString().toInt()
            val tuesdayTextMax = binding.etMax2.text.toString().toInt()
            val tuesdayCondition = binding.etCondition2.text.toString()
            val wednesdayTextMin = binding.etMin3.text.toString().toInt()
            val wednesdayTextMax = binding.etMax3.text.toString().toInt()
            val wednesdayCondition = binding.etCondition3.text.toString()
            val thursdayTextMin = binding.etMin4.text.toString().toInt()
            val thursdayTextMax = binding.etMax4.text.toString().toInt()
            val thursdayCondition = binding.etCondition4.text.toString()
            val fridayTextMin = binding.etMin5.text.toString().toInt()
            val fridayTextMax = binding.etMax5.text.toString().toInt()
            val fridayCondition = binding.etCondition5.text.toString()
            val saturdayTextMin = binding.etMin6.text.toString().toInt()
            val saturdayTextMax = binding.etMax6.text.toString().toInt()
            val saturdayCondition = binding.etCondition6.text.toString()
            val sundayTextMin = binding.etMin7.text.toString().toInt()
            val sundayTextMax = binding.etMax7.text.toString().toInt()
            val sundayCondition = binding.etCondition7.text.toString()

            val monday = Temperature(mondayTextMin, mondayTextMax, mondayCondition)
            val tuesday = Temperature(tuesdayTextMin, tuesdayTextMax, tuesdayCondition)
            val wednesday = Temperature(wednesdayTextMin, wednesdayTextMax, wednesdayCondition)
            val thursday = Temperature(thursdayTextMin, thursdayTextMax, thursdayCondition)
            val friday = Temperature(fridayTextMin, fridayTextMax, fridayCondition)
            val saturday = Temperature(saturdayTextMin, saturdayTextMax, saturdayCondition)
            val sunday = Temperature(sundayTextMin, sundayTextMax, sundayCondition)
            val temperatures = mutableListOf<Temperature>(monday, tuesday, wednesday, thursday, friday, saturday, sunday)

            var total = 0
            var count = 0

            for (temperature in temperatures) {
                total += temperature.max
                count++
            }

            val average = total / count
            binding.tvAverage.text = average.toString()
        }
    }
}

data class Temperature(val min: Int = 0, val max: Int, val info: String)




